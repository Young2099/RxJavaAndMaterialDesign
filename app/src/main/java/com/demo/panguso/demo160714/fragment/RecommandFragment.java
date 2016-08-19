package com.demo.panguso.demo160714.fragment;

import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.demo.panguso.demo160714.R;
import com.demo.panguso.demo160714.base.BaseFragment;
import com.demo.panguso.demo160714.view.PopupWindowMy;

/**
 * Created by panguso on 2016/7/15.
 */
public class RecommandFragment extends BaseFragment {
    private View mView;
    private Button btn;
    private PopupWindowMy popupWindowMy;
    @Override
    public View initView() {
        mView = View.inflate(activity, R.layout.recommend_fragment,null);
        btn = (Button) mView.findViewById(R.id.tv);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initPopuWindow();
                popupWindowMy.showAtLocation(getActivity().findViewById(R.id.lv), Gravity.CENTER | Gravity.BOTTOM, 0, 0);
                setParams(0.5f);
            }
        });
        return mView;
    }

    private void initPopuWindow() {
        popupWindowMy = new PopupWindowMy(getActivity(),itemOnclickListener);
    }
    private void setParams(float f) {
        WindowManager.LayoutParams params = getActivity().getWindow().getAttributes();
        params.alpha = f;
        params.dimAmount = f;
        getActivity().getWindow().setAttributes(params);
        getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
    }

    /**
     * poppwindow的监听事件
     */
    private View.OnClickListener itemOnclickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {

                default:
                    break;
            }
        }
    };

}
