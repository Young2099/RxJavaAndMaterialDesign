package com.demo.panguso.demo160714.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.demo.panguso.demo160714.ui.MainActivity;

/**
 * Created by panguso on 2016/7/15.
 *
 */
public abstract class BaseFragment extends Fragment {
    public MainActivity activity;
    public  View mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        activity = (MainActivity) getActivity();
        mView = initView();
        return mView;
    }

    public abstract View initView();
}
