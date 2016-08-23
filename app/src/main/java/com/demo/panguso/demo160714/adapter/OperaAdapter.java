package com.demo.panguso.demo160714.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

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
            headerViewHolder.mView.setImageResource(R.mipmap.e);
        } else if (getItemViewType(position) == TYPE_NORMAL1) {
            OperaViewHolder viewHolder = (OperaViewHolder) holder;
            viewHolder.mGridView.setAdapter(new CommonViewAdapter());
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
        Log.e("TAG", "DDDDDDD" + data.get(1).pic);
    }

    private class CommonViewAdapter extends BaseAdapter {

        public CommonViewAdapter() {
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
            return i;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (convertView == null) {
                convertView = View.inflate(mContext, R.layout.item_opera_grid, null);
                viewHolder = new ViewHolder();
                viewHolder.imageView = (ImageView) convertView.findViewById(R.id.iv_grid);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
//            viewHolder.imageView.setImageResource(R.mipmap.e);
            return convertView;
        }

        private class ViewHolder {
            ImageView imageView;
        }
    }
}
