package com.demo.panguso.demo160714.bean;

/**
 * Created by ${yangfang} on 2016/8/9.
 */
public class WeatherBean {
    private String city;
    private String pinyin;
    private String citycode;
    private String date;
    private String time;
    private String postCode;
    private int longitude;
    private int latitude;
    private String altitude;
    private String weather;
    private String temp;
    private String l_tmp;
    private String h_tmp;
    private String WD;
    private String WS;
    private String sunrise;
    private String sunset;

    @Override
    public String toString() {
        return "WeatherBean{" +
                "altitude='" + altitude + '\'' +
                ", city='" + city + '\'' +
                ", pinyin='" + pinyin + '\'' +
                ", citycode='" + citycode + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", postCode='" + postCode + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", weather='" + weather + '\'' +
                ", temp='" + temp + '\'' +
                ", l_tmp='" + l_tmp + '\'' +
                ", h_tmp='" + h_tmp + '\'' +
                ", WD='" + WD + '\'' +
                ", WS='" + WS + '\'' +
                ", sunrise='" + sunrise + '\'' +
                ", sunset='" + sunset + '\'' +
                '}';
    }
}
