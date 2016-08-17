package com.demo.panguso.demo160714.utility.imageview;

import android.app.ActivityManager;
import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;


/**
 * Created by yangfang on 2016/6/15.
 */
public class ImageCacheManager {
    private Context mContext;
    private final int MEM_CACHE_MAX;
    //在这里创建图片的本地缓存和内存缓存，
    private ImageLruCache mImageLruCache, mImageLruCacheWithMemory;
    //volley的图片加载方法ImageLoader分成本地加载和内存加载
    private ImageLoader mIamgerLoader, mImageLoaderWithMemory;

    public ImageCacheManager(Context context) {
        mContext = context;
        MEM_CACHE_MAX = 1024 * 1024 * ((ActivityManager) mContext.getSystemService(Context.ACTIVITY_SERVICE)).getMemoryClass() / 8;

        mImageLruCache = new ImageLruCache(mContext, MEM_CACHE_MAX, false);
        mIamgerLoader = new ImageLoader(Volley.newRequestQueue(context), mImageLruCache);

        mImageLruCacheWithMemory = new ImageLruCache(context, MEM_CACHE_MAX, true);
        mImageLoaderWithMemory = new ImageLoader(Volley.newRequestQueue(mContext), mImageLruCacheWithMemory);
    }

    /**
     * 默认这是开启硬盘缓存
     *
     * @param url
     * @param view
     * @param defaultImageResourceId
     * @param errorImageResourceId
     * @return
     */
    public ImageLoader.ImageContainer loadImage(final String url, final ImageView view, final int defaultImageResourceId, final int errorImageResourceId) {
        if (TextUtils.isEmpty(url)) {
            return null;
        }
        return mIamgerLoader.get(url, ImageLoader.getImageListener(view, defaultImageResourceId, errorImageResourceId), 0, 0);
    }

    /**
     * 开启的是硬盘缓存
     *
     * @param url
     * @param imageListener
     * @return
     */
    public ImageLoader.ImageContainer loadImage(final String url, ImageLoader.ImageListener imageListener) {
        if (TextUtils.isEmpty(url)) {
            return null;
        }
        return mIamgerLoader.get(url, imageListener, 0, 0);
    }

    /**
     * 将url处图片呈现在view上，内存硬盘双缓存。
     * @param url
     * @param view
     * @param defaultImageResourceId
     * @param errorImageResourceId
     * @return
     */
    public  ImageLoader.ImageContainer loadImageWithMemory(final String url, final ImageView view,final int defaultImageResourceId, final int errorImageResourceId){
        if(TextUtils.isEmpty(url))return null;
        return mImageLoaderWithMemory.get(url,ImageLoader.getImageListener(view, defaultImageResourceId,errorImageResourceId), 0, 0);
    }

}
