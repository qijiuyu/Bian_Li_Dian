package com.zxdc.http.library.bean;

import java.io.Serializable;

/**
 * 首页消息
 */
public class News extends BaseBean {

    private NewsBean data;

    public NewsBean getData() {
        return data;
    }

    public void setData(NewsBean data) {
        this.data = data;
    }

    public static class NewsBean implements Serializable{
        //大于0表示有未读消息
        private int flag;
        private Hint messageInfo;

        private Abvert bombMsg;

        public int getFlag() {
            return flag;
        }

        public void setFlag(int flag) {
            this.flag = flag;
        }

        public Hint getMessageInfo() {
            return messageInfo;
        }

        public void setMessageInfo(Hint messageInfo) {
            this.messageInfo = messageInfo;
        }

        public Abvert getBombMsg() {
            return bombMsg;
        }

        public void setBombMsg(Abvert bombMsg) {
            this.bombMsg = bombMsg;
        }
    }

    public static class Hint implements Serializable{
        private String title;
        private String details;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }
    }

    public static class Abvert implements Serializable{

        private String id;
        private String title;
        private String details;
        private String url;
        private String image_url;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }
    }
}
