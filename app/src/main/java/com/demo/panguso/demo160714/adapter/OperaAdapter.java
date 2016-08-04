package com.demo.panguso.demo160714.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.demo.panguso.demo160714.R;
import com.demo.panguso.demo160714.holder.OperaViewHolder;

/**
 * Created by ${yangfang} on 2016/8/2.
 * 番剧页面的Adpater
 */
public class OperaAdapter extends RecyclerView.Adapter<OperaViewHolder> {
    View mHeaderView;
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_NORMAL1 = 1;
    Context mContext;

    public OperaAdapter(Context context) {
        mContext = context;
    }

    @Override
    public OperaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType) {
            case TYPE_HEADER:
                view = mHeaderView;
                break;
            case TYPE_NORMAL1:
                view = View.inflate(mContext, R.layout.opera_item1, null);
                break;
            default:
                break;
        }
        return new OperaViewHolder(view, mContext);
    }

    @Override
    public void onBindViewHolder(OperaViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case TYPE_HEADER:
                holder.imageViewOpera.setImageResource(R.mipmap.e);
                break;
            case TYPE_NORMAL1:
                holder.mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 3));
                GridViewAdapter mAdapter = new GridViewAdapter();
                holder.mRecyclerView.setAdapter(mAdapter);
                break;
            default:
                break;
        }

    }

    @Override
    public int getItemViewType(int position) {
        int type;
        if (position == 0) {
            type = TYPE_HEADER;
        } else {
            type = TYPE_NORMAL1;
        }

        return type;
    }

    public void setHeaderView(View headerView) {
        mHeaderView = headerView;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}