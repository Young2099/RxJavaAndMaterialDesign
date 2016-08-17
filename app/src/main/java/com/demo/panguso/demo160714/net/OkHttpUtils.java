package com.demo.panguso.demo160714.net;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

/**
 * Created by ${yangfang} on 2016/8/8.
 */
public class OkHttpUtils {
    private static OkHttpUtils okHttpUtils;
    private OkHttpClient mOkHttpClient;

    private OkHttpUtils() {
        mOkHttpClient = new OkHttpClient();
    }

    public static OkHttpUtils getInstance() {
        if (okHttpUtils == null) {
            synchronized (OkHttpUtils.class) {
                if (okHttpUtils == null) {
                    okHttpUtils = new OkHttpUtils();
                }
            }
        }
        return okHttpUtils;
    }

    /**
     * 异步的get请求
     *
     * @param url
     * @param callback
     */
    public void getAscy(String url, Callback callback) {
        Request request = new Request.Builder()
                .url(url)
                .build();
        mOkHttpClient.newCall(request).enqueue(callback);
    }

}
