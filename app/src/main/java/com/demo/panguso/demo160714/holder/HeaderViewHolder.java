package com.demo.panguso.demo160714.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import com.demo.panguso.demo160714.R;

/**
 * Created by ${yangfang} on 2016/8/24.
 */
public class HeaderViewHolder extends RecyclerView.ViewHolder {
    public ImageView mImageView;
    public GridView gridView;
    public HeaderViewHolder(View headerView) {
        super(headerView);
        mImageView = (ImageView) headerView.findViewById(R.id.iv_grid);
        gridView = (GridView) headerView.findViewById(R.id.gridview);
    }
}
