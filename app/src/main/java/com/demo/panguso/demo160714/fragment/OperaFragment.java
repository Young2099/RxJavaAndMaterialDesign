package com.demo.panguso.demo160714.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
    private View mView;
    RecyclerView mRecyclerView;
    OperaAdapter mOperaAdapter;
    List<OperaMainBean.WeSeeItem> weSeeItems;

    @Override
    public View initView() {
        mView = View.inflate(activity, R.layout.opera_fragment, null);
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.opera_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        intData();
        mOperaAdapter = new OperaAdapter(getActivity(),weSeeItems);
        mRecyclerView.setAdapter(mOperaAdapter);
        return mView;
    }

    private void intData() {
        OkHttpUtils.getInstance().getAscy(ConstantUrl.Opera2Url, new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                String value = response.body().string();
                try {
                    weSeeItems = OperaMainBean.getData(value);
                    Log.e("TAG",weSeeItems.get(1).aid);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}

