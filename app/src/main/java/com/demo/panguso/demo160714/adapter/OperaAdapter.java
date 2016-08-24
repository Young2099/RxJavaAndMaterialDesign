package com.demo.panguso.demo160714.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demo.panguso.demo160714.R;
import com.demo.panguso.demo160714.bean.OperaMainBean;
import com.demo.panguso.demo160714.holder.HeaderViewHolder;
import com.demo.panguso.demo160714.holder.OperaViewHolder;

import java.util.List;

/**
 * Created by ${yangfang} on 2016/8/23.
 */
public class OperaAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_NORMAL1 = 1;
    private View headerView;
    private Context mContext;
    private List<OperaMainBean.WeSeeItem> data;

    public OperaAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getItemViewType(int position) {
        int type = 0;
        if (position == 0) {
            type = TYPE_HEADER;
        } else if (position == 1) {
            type = TYPE_NORMAL1;
        }
        return type;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null;
        if (viewType == TYPE_HEADER) {
            holder = new HeaderViewHolder(headerView);
        } else if (viewType == TYPE_NORMAL1) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.opera_gridview, null);
            holder = new OperaViewHolder(view);
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_HEADER) {
            HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
            headerViewHolder.mImageView.setImageResource(R.mipmap.e);
        } else if (getItemViewType(position) == TYPE_NORMAL1) {
            OperaViewHolder viewHolder = (OperaViewHolder) holder;
            viewHolder.mGridView.setAdapter(new CommonViewAdapter(mContext,data));
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public void setHeaderView(View headerView) {
        this.headerView = headerView;
    }

    public void setData(List<OperaMainBean.WeSeeItem> data) {
        this.data = data;
    }


}
