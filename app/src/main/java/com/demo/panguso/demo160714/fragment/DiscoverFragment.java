package com.demo.panguso.demo160714.fragment;

import android.view.View;

import com.demo.panguso.demo160714.R;
import com.demo.panguso.demo160714.base.BaseFragment;

/**
 * Created by panguso on 2016/7/15.
 */
public class DiscoverFragment extends BaseFragment {
    private View mView;
    @Override
    public View initView() {
        mView = View.inflate(activity, R.layout.recommend_fragment,null);
        return mView;
    }
}
