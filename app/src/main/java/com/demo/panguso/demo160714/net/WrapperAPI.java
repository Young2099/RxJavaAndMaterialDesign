package com.demo.panguso.demo160714.net;

import com.demo.panguso.demo160714.bean.OperaMainBean;

import rx.Observable;

/**
 * Created by ${yangfang} on 2016/8/5.
 */
public class WrapperAPI extends NetWorkService {
    public WrapperAPI() {

    }

    private static WrapperAPI mWrapperAPI;

    public static WrapperAPI getInstance() {
        if (mWrapperAPI == null) {
            synchronized (WrapperAPI.class) {
                if (mWrapperAPI == null) {
                    mWrapperAPI = new WrapperAPI();
                }
            }
        }
        return mWrapperAPI;
    }

//    public Observable<String> getSmsCode(String mobile) {
//        return getService().getSmsCode(mobile, "")
//                .compose(this.<String>applySchedulers());
//    }
    public Observable<OperaMainBean> getOperaData(){
        return getService().getResult().compose(this.<OperaMainBean>applySchedulers());
    }

}
