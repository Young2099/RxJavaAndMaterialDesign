package com.demo.panguso.demo160714.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demo.panguso.demo160714.R;
import com.demo.panguso.demo160714.bean.OperaMainBean;
import com.demo.panguso.demo160714.holder.OperaViewHolder;

import java.util.List;

/**
 * Created by ${yangfang} on 2016/8/2.
 * 番剧页面的Adpater
 */
public class OperaAdapter extends RecyclerView.Adapter<OperaViewHolder> {
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_NORMAL1 = 1;
    private List<OperaMainBean.WeSeeItem> data;
    Context mContext;

    public OperaAdapter(Context context, List<OperaMainBean.WeSeeItem> weSeeItems) {
        mContext = context;
        this.data = weSeeItems;
    }

    @Override
    public OperaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        OperaViewHolder viewHolder = null;
        switch (viewType) {
            case TYPE_NORMAL1:
                View view  =  LayoutInflater.from(mContext).inflate(R.layout.opera_item1, parent, false);
                viewHolder = new OperaViewHolder(view);
                break;
            default:
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(OperaViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case TYPE_NORMAL1:
                GridViewAdapter gridViewAdapter = new GridViewAdapter(mContext,data);
                holder.mGridView.setAdapter(gridViewAdapter);
                break;
            default:
                break;
        }

    }

    @Override
    public int getItemViewType(int position) {
        int type = 0;
        if (position == 0)
            type = TYPE_NORMAL1;
        return type;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
