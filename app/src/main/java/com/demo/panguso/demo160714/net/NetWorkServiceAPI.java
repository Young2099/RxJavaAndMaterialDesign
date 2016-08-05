package com.demo.panguso.demo160714.net;

import com.demo.panguso.demo160714.bean.OperaMainBean;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by ${yangfang} on 2016/8/5.
 */
public interface NetWorkServiceAPI {
    @FormUrlEncoded
    @POST("api/common/msg.json")
    Observable<Response<String>> getSmsCode(@Field("mobile") String mobile, @Field("appType") String appType);

    @GET("online_list?_device=android&platform=android&typeid=13&sign=a520d8d8f7a7240013006e466c8044f7")
    Observable<Response<OperaMainBean>> getResult();

}