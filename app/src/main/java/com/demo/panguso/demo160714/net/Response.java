package com.demo.panguso.demo160714.net;


/**
 * Created by ${yangfang} on 2016/8/4.
 */
public class Response<T> {
    public String code;
    public String message;
    public T object;

    public boolean isSuccess() {
        return code.equals("Success");
    }

}
