package com.demo.panguso.demo160714.holder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by ${yangfang} on 2016/8/2.
 */
public class OperaViewHolder extends RecyclerView.ViewHolder {

    public ImageView imageViewOpera;
    Context mContext;

    public OperaViewHolder(View itemView, Context context) {
        super(itemView);
        mContext = context;

    }

}
