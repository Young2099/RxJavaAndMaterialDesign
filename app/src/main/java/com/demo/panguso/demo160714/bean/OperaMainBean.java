package com.demo.panguso.demo160714.bean;

import com.demo.panguso.demo160714.net.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ${yangfang} on 2016/8/5.
 */
public class OperaMainBean extends Response {
    String code;

    /**
     * JSON数据返回的是对象
     */
    public static class WeSeeItem {
        public String aid;
        public String author;
        public Integer coins;
        public String copyright;
        public String create;
        public Integer credit;
        public String description;
        public String duration;
        public Integer favorites;
        public Integer mid;
        public Integer online;
        public String pic;
        public String play;
        public Integer review;
        public String subtitle;
        public String title;
        public Integer typeid;
        public String typename;
        public String video_review;


        public static WeSeeItem getWeSeeItem(JSONObject value) {
            WeSeeItem mWeSeeItem = new WeSeeItem();
            if (value.has("aid")) {
                mWeSeeItem.aid = (String) value.opt("aid");
            }
            if (value.has("author")) {
                mWeSeeItem.author = (String) value.opt("author");
            }
            if (value.has("coins")) {
                mWeSeeItem.coins = (Integer) value.opt("coins");
            }
            if (value.has("copyright")) {
                mWeSeeItem.copyright = (String) value.opt("copyright");
            }
            if (value.has("create")) {
                mWeSeeItem.create = (String) value.opt("create");
            }
            if (value.has("credit")) {
                mWeSeeItem.credit = (Integer) value.opt("credit");
            }
            if (value.has("description")) {
                mWeSeeItem.description = (String) value.opt("description");
            }
            if (value.has("duration")) {
                mWeSeeItem.duration = (String) value.opt("duration");
            }
            if (value.has("favorites")) {
                mWeSeeItem.favorites = (Integer) value.opt("favorites");
            }
            if (value.has("mid")) {
                mWeSeeItem.mid = (Integer) value.opt("mid");
            }
            if (value.has("online")) {
                mWeSeeItem.online = (Integer) value.opt("online");
            }
            if (value.has("pic")) {
                mWeSeeItem.pic = (String) value.opt("pic");
            }
            if (value.has("play")) {
                mWeSeeItem.play = (String) value.opt("play");
            }
            if (value.has("review")) {
                mWeSeeItem.review = (Integer) value.opt("review");
            }
            if (value.has("subtitle")) {
                mWeSeeItem.subtitle = (String) value.opt("subtitle");
            }
            if (value.has("title")) {
                mWeSeeItem.title = (String) value.opt("title");
            }
            if (value.has("typeid")) {
                mWeSeeItem.typeid = (Integer) value.opt("typeid");
            }
            if (value.has("typename")) {
                mWeSeeItem.typename = (String) value.opt("typename");
            }
            if (value.has("video_review")) {
                mWeSeeItem.video_review = (String) value.opt("video_review");
            }

            return mWeSeeItem;
        }
    }

    public static List<WeSeeItem> getData(String json) throws JSONException {
        List<WeSeeItem> mWeSeeItems = new ArrayList<>();
        JSONObject jsonObject = new JSONObject(json);
        if (jsonObject.has("list")) {
            JSONObject list = (JSONObject) jsonObject.opt("list");
            Iterator iterator = list.keys();
            while (iterator.hasNext()) {
                String key = (String) iterator.next();
                JSONObject value = (JSONObject) list.opt(key);
                WeSeeItem weSeeItem = WeSeeItem.getWeSeeItem(value);
                mWeSeeItems.add(weSeeItem);
            }
        }
        return mWeSeeItems;
    }

}
