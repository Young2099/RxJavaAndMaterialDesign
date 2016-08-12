package com.demo.panguso.demo160714.bean;

import java.util.List;

/**
 * Created by ${yangfang} on 2016/8/8.
 */
public class Opera2Bean {
    public List<Banners> banners;
    public List<News> news;
    public List<Recommends> recommends;

    @Override
    public String toString() {
        return "Opera2Bean{" +
                "bannerses=" + banners +
                ", newses=" + news +
                ", recommends=" + recommends +
                '}';
    }

    public static class Banners {
        private String title;
        private String link;
        private String img;
        private String simg;
        private int aid;
        private String type;
        private int platform;
        private int pid;

        public int getAid() {
            return aid;
        }

        public String getType() {
            return type;
        }

        public String getTitle() {
            return title;
        }

        public String getSimg() {
            return simg;
        }

        public int getPlatform() {
            return platform;
        }

        public int getPid() {
            return pid;
        }

        public String getLink() {
            return link;
        }

        public String getImg() {
            return img;
        }

        @Override
        public String toString() {
            return "Banners{" +
                    "aid=" + aid +
                    ", title='" + title + '\'' +
                    ", link='" + link + '\'' +
                    ", img='" + img + '\'' +
                    ", simg='" + simg + '\'' +
                    ", type='" + type + '\'' +
                    ", platform=" + platform +
                    ", pid=" + pid +
                    '}';
        }
    }

    public static class News {
        private String aid;
        private String copyright;
        private int typeid;
        private String typename;
        private String title;
        private String subtitle;
        private int play;
        private int review;
        private int video_review;
        private int favorites;
        private int mid;
        private String author;
        private String description;
        private String create;
        private String pic;
        private int credit;
        private int coins;
        private String duration;
        private int comment;

        @Override
        public String toString() {
            return "News{" +
                    "aid='" + aid + '\'' +
                    ", copyright='" + copyright + '\'' +
                    ", typeid=" + typeid +
                    ", typename='" + typename + '\'' +
                    ", title='" + title + '\'' +
                    ", subtitle='" + subtitle + '\'' +
                    ", play=" + play +
                    ", review=" + review +
                    ", video_review=" + video_review +
                    ", favorites=" + favorites +
                    ", mid=" + mid +
                    ", author='" + author + '\'' +
                    ", description='" + description + '\'' +
                    ", create='" + create + '\'' +
                    ", pic='" + pic + '\'' +
                    ", credit=" + credit +
                    ", coins=" + coins +
                    ", duration='" + duration + '\'' +
                    ", comment=" + comment +
                    '}';
        }

        public String getAid() {
            return aid;
        }

        public String getAuthor() {
            return author;
        }

        public int getCoins() {
            return coins;
        }

        public String getCopyright() {
            return copyright;
        }

        public String getCreate() {
            return create;
        }

        public int getComment() {
            return comment;
        }

        public int getCredit() {
            return credit;
        }

        public String getDescription() {
            return description;
        }

        public String getDuration() {
            return duration;
        }

        public int getFavorites() {
            return favorites;
        }

        public int getPlay() {
            return play;
        }

        public String getPic() {
            return pic;
        }

        public int getMid() {
            return mid;
        }

        public int getReview() {
            return review;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public String getTitle() {
            return title;
        }

        public int getTypeid() {
            return typeid;
        }

        public String getTypename() {
            return typename;
        }

        public int getVideo_review() {
            return video_review;
        }
    }

    private class Recommends {
        private String aid;
        private String title;
        private String subtitle;
        private int play;
        private int review;
        private int video_review;
        private int favorites;
        private int mid;
        private String author;
        private String description;
        private String create;
        private String pic;
        private int coins;
        private String duration;
        private boolean badgepay;

        public String getAid() {
            return aid;
        }

        public int getVideo_review() {
            return video_review;
        }

        public String getPic() {
            return pic;
        }

        public int getMid() {
            return mid;
        }

        public String getDuration() {
            return duration;
        }

        public String getDescription() {
            return description;
        }

        public int getCoins() {
            return coins;
        }

        public boolean isBadgepay() {
            return badgepay;
        }

        public String getAuthor() {
            return author;
        }

        public String getCreate() {
            return create;
        }

        public int getFavorites() {
            return favorites;
        }

        public int getPlay() {
            return play;
        }

        public int getReview() {
            return review;
        }

        public String getTitle() {
            return title;
        }

        public String getSubtitle() {
            return subtitle;
        }

        @Override
        public String toString() {
            return "Recommends{" +
                    "aid='" + aid + '\'' +
                    ", title='" + title + '\'' +
                    ", subtitle='" + subtitle + '\'' +
                    ", play=" + play +
                    ", review=" + review +
                    ", video_review=" + video_review +
                    ", favorites=" + favorites +
                    ", mid=" + mid +
                    ", author='" + author + '\'' +
                    ", description='" + description + '\'' +
                    ", create='" + create + '\'' +
                    ", pic='" + pic + '\'' +
                    ", coins=" + coins +
                    ", duration='" + duration + '\'' +
                    ", badgepay=" + badgepay +
                    '}';
        }
    }

}
