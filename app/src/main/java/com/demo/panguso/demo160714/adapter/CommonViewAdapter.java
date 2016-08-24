package com.demo.panguso.demo160714.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.demo.panguso.demo160714.R;
import com.demo.panguso.demo160714.bean.OperaMainBean;
import com.demo.panguso.demo160714.ui.MainActivity;

import java.util.List;

/**
 * Created by ${yangfang} on 2016/8/24.
 */
public class CommonViewAdapter extends BaseAdapter {
    private Context mContext;
    private List<OperaMainBean.WeSeeItem> weSeeItems;

    public CommonViewAdapter(Context mContext, List<OperaMainBean.WeSeeItem> data) {
        this.mContext = mContext;
        weSeeItems = data;
    }

    @Override
    public int getCount() {
        if (weSeeItems == null) {
            return 0;
        }
        return 6;
    }

    @Override
    public Object getItem(int i) {
        if (weSeeItems == null) {
            return null;
        }
        return weSeeItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.item_opera_grid, null);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.iv_grid);
            viewHolder.imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE); // 设置缩放方式
            viewHolder.imageView.setPadding(5, 0, 5, 0); // 设置ImageView的内边距
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
//        ImageLoader.getInstance().displayImage(weSeeItems.get(position).pic, viewHolder.imageView, ImageLoaderOptions.getDefaultOptions());
        ((MainActivity) mContext).getImageCacher().loadImage(weSeeItems.get(position).pic, viewHolder.imageView, R.mipmap.ic_launcher, R.mipmap.ic_launcher);
        return convertView;
    }

    private class ViewHolder {
        ImageView imageView;
    }
}