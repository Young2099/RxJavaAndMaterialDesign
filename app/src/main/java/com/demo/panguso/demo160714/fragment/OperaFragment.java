package com.demo.panguso.demo160714.fragment;

import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.demo.panguso.demo160714.R;
import com.demo.panguso.demo160714.adapter.OperaAdapter;
import com.demo.panguso.demo160714.base.BaseFragment;
import com.demo.panguso.demo160714.bean.OperaMainBean;
import com.demo.panguso.demo160714.net.OkHttpUtils;
import com.demo.panguso.demo160714.utility.ConstantUrl;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

/**
 * Created by panguso on 2016/7/15.
 */
public class OperaFragment extends BaseFragment {
    public static final int WHAT_SUCESS = 1;

    private View mView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private OperaAdapter mOperaAdapter;
    private View mHeaderView;
    private List<OperaMainBean.WeSeeItem> weSeeItems;
    private android.os.Handler handler = new android.os.Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what == WHAT_SUCESS){
                mOperaAdapter.setData(weSeeItems);
                mOperaAdapter.notifyDataSetChanged();
            }
        }
    };

    @Override
    public View initView() {
        mView = View.inflate(activity, R.layout.opera_fragment, null);
        intView(mView);
        return mView;
    }

    private void intView(View mView) {
        swipeRefreshLayout = (SwipeRefreshLayout) mView.findViewById(R.id.swiprefresh);
        recyclerView = (RecyclerView) mView.findViewById(R.id.opera_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        mOperaAdapter = new OperaAdapter(activity);
        initData();
        mHeaderView = LayoutInflater.from(activity).inflate(R.layout.opera_header_view, null);
        mOperaAdapter.setHeaderView(mHeaderView);
        recyclerView.setAdapter(mOperaAdapter);
    }
    private void initData() {
        OkHttpUtils.getInstance().getAscy(ConstantUrl.Opera2Url, new Callback() {

            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                    String value = response.body().string();
                    try {
                        weSeeItems = OperaMainBean.getData(value);
                        Log.e("TAG","w"+weSeeItems.get(1).pic);
                        handler.sendEmptyMessage(WHAT_SUCESS);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

        });
    }

}

