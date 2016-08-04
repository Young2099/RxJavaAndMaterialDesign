package com.demo.panguso.demo160714.holder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.demo.panguso.demo160714.R;

/**
 * Created by ${yangfang} on 2016/8/2.
 */
public class OperaViewHolder extends RecyclerView.ViewHolder {
    public RecyclerView mRecyclerView;
    public ImageView imageViewOpera;
    Context mContext;

    public OperaViewHolder(View itemView, Context context) {
        super(itemView);
        if(itemView instanceof LinearLayout){

        }
        mContext = context;
        mRecyclerView = (RecyclerView) itemView.findViewById(R.id.opera_gridview);
        imageViewOpera = (ImageView) itemView.findViewById(R.id.opera_image);
    }

}
