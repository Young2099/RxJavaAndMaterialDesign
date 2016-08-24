package com.demo.panguso.demo160714.utility.imageview;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Environment;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader;
import com.squareup.okhttp.internal.DiskLruCache;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * Created by yangfang on 2016/6/15.
 */
public class ImageLruCache extends LruCache<String, Bitmap> implements ImageLoader.ImageCache {

    private static DiskLruCache mDiskLruCache;
    private boolean mIsMemoryCache;

    /**
     * @param maxSize for caches that do not override {@link #sizeOf}, this is
     *                the maximum number of entries in the cache. For all other caches,
     *                this is the maximum sum of the sizes of the entries in this cache.
     */
    public ImageLruCache(Context context, int maxSize, boolean isMemoryCacheCache) {
        super(maxSize);
        mIsMemoryCache = isMemoryCacheCache;
        try {
            mDiskLruCache = DiskLruCache.open(getDiskCache(context, "images"), getAppVersion(context), 1, 10 * 1024 * 1024);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected int sizeOf(String key, Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1) {
            return bitmap.getByteCount();
        }
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    /**
     * 获取版本号
     *
     * @param context
     * @return
     */
    private int getAppVersion(Context context) {
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return info.versionCode;//获取版本号
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return 1;
    }

    /**
     * 选择缓存图片的地址
     *
     * @param context
     * @param images
     * @return
     */
    private File getDiskCache(Context context, String images) {
        String cachePath;

        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
                || !Environment.isExternalStorageRemovable()) {
            if(context!=null && context.getExternalCacheDir()!=null){
                cachePath =context.getExternalCacheDir().getPath() ;
            }else{
                cachePath = context.getCacheDir().getPath();
            }


        } else {
            cachePath = context.getCacheDir().getPath();
        }
        return new File(cachePath + File.separator + images);
    }

    @Override
    public Bitmap getBitmap(String url) {
        Bitmap data = null;
        if (mIsMemoryCache) {
            data = get(url);
            if (data != null) {
                return data;
            } else {
                String key = hashKeyForDisk(url);
                try {
                    DiskLruCache.Snapshot snapShot = mDiskLruCache.get(key);
                    if (snapShot != null) {
                        InputStream is = snapShot.getInputStream(0);
                        data = BitmapFactory.decodeStream(is);
                    }
                    if (data != null) {
                        put(url, data);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            String key = hashKeyForDisk(url);
            try {
                DiskLruCache.Snapshot snapShot = mDiskLruCache.get(key);
                if (snapShot != null) {
                    InputStream is = snapShot.getInputStream(0);
                    data = BitmapFactory.decodeStream(is);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        //内存缓存
        if (mIsMemoryCache) {
            put(url, bitmap);
        }
        //自定义的磁盘缓存（关闭volley自带的磁盘缓存（设置request的shouldcache)
        String key = hashKeyForDisk(url);
        try {
            if (mDiskLruCache.get(key) == null) {
                DiskLruCache.Editor editor = mDiskLruCache.edit(key);
                if (editor != null) {
                    OutputStream outputStream = editor.newOutputStream(0);
                    if (bitmap.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)) {
                        editor.commit();
                    } else {
                        editor.abort();
                    }

                }
                mDiskLruCache.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //根据key生成md5值，保证缓存文件名称的合法化
    private String hashKeyForDisk(String key) {
        String cacheKey;
        try {
            final MessageDigest mDigest = MessageDigest.getInstance("MD5");
            mDigest.update(key.getBytes());
            cacheKey = bytesToHexString(mDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            cacheKey = String.valueOf(key.hashCode());
        }
        return cacheKey;
    }

    private String bytesToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(0xFF & bytes[i]);
            if (hex.length() == 1) {
                sb.append('0');
            }
            sb.append(hex);
        }
        return sb.toString();
    }
}
