package com.demo.panguso.demo160714.net;

import com.demo.panguso.demo160714.bean.OperaMainBean;
import com.demo.panguso.demo160714.bean.WeatherBean;

import java.util.List;

import rx.Observable;

/**
 * Created by ${yangfang} on 2016/8/5.
 */
public class WrapperAPI extends NetWorkService {

    public Observable<List<OperaMainBean.WeSeeItem>> getDatas() {
        return getService().getOperaData().compose(this.<List<OperaMainBean.WeSeeItem>>applySchedulers());
    }

    public Observable<WeatherBean>getWeather(){
        return getService().getWeather("beijing").compose(this.<WeatherBean>applySchedulers());
    }
}
