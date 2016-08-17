package com.demo.panguso.demo160714.net;

import com.demo.panguso.demo160714.bean.OperaMainBean;
import com.demo.panguso.demo160714.bean.WeatherBean;

import rx.Observable;

/**
 * Created by ${yangfang} on 2016/8/5.
 */
public class WrapperAPI extends NetWorkService {

    public Observable<OperaMainBean> getDatas() {
        return getService().getOperaData().compose(this.<OperaMainBean>applySchedulers());
    }

    public Observable<WeatherBean>getWeather(){
        return getService().getWeather("beijing").compose(this.<WeatherBean>applySchedulers());
    }
}
