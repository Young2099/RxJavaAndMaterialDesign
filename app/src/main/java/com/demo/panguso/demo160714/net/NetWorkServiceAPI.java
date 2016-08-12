package com.demo.panguso.demo160714.net;

import com.demo.panguso.demo160714.bean.OperaMainBean;
import com.demo.panguso.demo160714.bean.WeatherBean;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by ${yangfang} on 2016/8/5.
 */
public interface NetWorkServiceAPI {
    /**
     * 获取帖子分类列表
     *
     * @return
     */

    @GET("online_list?_device=android&platform=android&typeid=13&sign=a520d8d8f7a7240013006e466c8044f7")
    Observable<Response<List<OperaMainBean.WeSeeItem>>> getOperaData();

    @GET("/microservice/weather")
    Observable<Response<WeatherBean>> getWeather(@Query("citypinyin") String city);
}