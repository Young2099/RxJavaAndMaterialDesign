package com.demo.panguso.demo160714.net;


/**
 * Created by ${yangfang} on 2016/8/4.
 */
public class Response<T> {
    public int errNum;
    public String errMsg;
    public T list;

    public boolean isSuccess() {
        return errNum == 0;
    }


    public int getCode() {
        return errNum;
    }
    public String getErrMsg() {
        return errMsg;
    }

    public T getData() {
        return list;
    }
}
