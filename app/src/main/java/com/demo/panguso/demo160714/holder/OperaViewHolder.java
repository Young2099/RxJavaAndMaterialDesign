package com.demo.panguso.demo160714.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.GridView;

import com.demo.panguso.demo160714.R;

/**
 * Created by ${yangfang} on 2016/8/23.
 */
public class OperaViewHolder extends RecyclerView.ViewHolder {
    public GridView mGridView;

    public OperaViewHolder(View view) {
        super(view);
        mGridView = (GridView) view.findViewById(R.id.girdView);
    }
}
