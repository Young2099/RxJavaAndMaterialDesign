package com.demo.panguso.demo160714.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by ${yangfang} on 2016/8/2.
 */
public class MyApplication extends Application {
    public static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }
    public MyApplication(){}

}
