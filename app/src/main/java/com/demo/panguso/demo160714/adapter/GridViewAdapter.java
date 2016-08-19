package com.demo.panguso.demo160714.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.demo.panguso.demo160714.R;
import com.demo.panguso.demo160714.bean.OperaMainBean;
import com.demo.panguso.demo160714.utility.imageview.ImageCacheManager;

import java.util.List;

/**
 * Created by ${yangfang} on 2016/8/19.
 */
public class GridViewAdapter extends BaseAdapter {
    private List<OperaMainBean.WeSeeItem> data;
    private Context mContext;

    public GridViewAdapter(Context context, List<OperaMainBean.WeSeeItem> data) {
        this.data = data;
        mContext = context;
    }

    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        final Holder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.opera_item2, null);
            holder = new Holder();
            holder.mImageView = (ImageView) convertView.findViewById(R.id.iv_item2);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        ImageCacheManager imageCacheManager = new ImageCacheManager(mContext);
//        imageCacheManager.loadImage(data.get(i).pic, new ImageLoader.ImageListener() {
//            @Override
//            public void onResponse(ImageLoader.ImageContainer imageContainer, boolean b) {
//                holder.mImageView.setImageBitmap(imageContainer.getBitmap());
//            }
//
//            @Override
//            public void onErrorResponse(VolleyError volleyError) {
//
//            }
//        });
        return convertView;
    }

    private class Holder {
        protected ImageView mImageView;
        protected TextView mName;

    }
}
