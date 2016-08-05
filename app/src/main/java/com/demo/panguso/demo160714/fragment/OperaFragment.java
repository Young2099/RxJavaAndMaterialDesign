package com.demo.panguso.demo160714.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.demo.panguso.demo160714.R;
import com.demo.panguso.demo160714.adapter.OperaAdapter;
import com.demo.panguso.demo160714.base.BaseFragment;
import com.demo.panguso.demo160714.bean.OperaMainBean;
import com.demo.panguso.demo160714.net.WrapperAPI;

import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by panguso on 2016/7/15.
 */
public class OperaFragment extends BaseFragment {
    private View mView;
    RecyclerView mRecyclerView;
    View mHeader;
    OperaAdapter mOperaAdapter;

    @Override
    public View initView() {
        mView = View.inflate(activity, R.layout.opera_fragment, null);
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.opera_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mHeader = View.inflate(getActivity(), R.layout.opera_header, null);
        mOperaAdapter = new OperaAdapter(getActivity());
        mOperaAdapter.setHeaderView(mHeader);
        mRecyclerView.setAdapter(mOperaAdapter);
        initData();
        return mView;
    }

    /**
     * 初始化页面的数据
     */
    private void initData() {
        Subscription mSubscription = WrapperAPI.getInstance().getOperaData()
                .subscribe(new Action1<OperaMainBean>() {
                    @Override
                    public void call(OperaMainBean o) {
                        Log.e("TAG", "////");
                    }


                });
        mCompositeSubscription.add(mSubscription);
    }

}

