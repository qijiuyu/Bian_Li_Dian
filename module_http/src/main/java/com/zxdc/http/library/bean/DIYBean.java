package com.zxdc.http.library.bean;

import java.io.Serializable;
import java.util.List;

public class DIYBean extends BaseBean{

    private DIYBean.DazzleHomeBean data;

    public DIYBean.DazzleHomeBean getData() {
        return data;
    }

    public void setData(DIYBean.DazzleHomeBean data) {
        this.data = data;
    }

    public static class DazzleHomeBean implements Serializable{
        private List<DazzleBean> templateList;
        private DIYBean.MyDazzleBean userTemplate;
        private List<DIYBean.DazlleTemplateDeatil> templateDeatil;

        public List<DazzleBean> getTemplateList() {
            return templateList;
        }

        public void setTemplateList(List<DazzleBean> templateList) {
            this.templateList = templateList;
        }

        public DIYBean.MyDazzleBean getUserTemplate() {
            return userTemplate;
        }

        public void setUserTemplate(DIYBean.MyDazzleBean userTemplate) {
            this.userTemplate = userTemplate;
        }

        public List<DIYBean.DazlleTemplateDeatil> getTemplateDeatil() {
            return templateDeatil;
        }

        public void setTemplateDeatil(List<DIYBean.DazlleTemplateDeatil> templateDeatil) {
            this.templateDeatil = templateDeatil;
        }
    }
    public static class MyDazzleBean implements Serializable {
        private String id;
        private String templateNum;
        private String userId;
        private int    status;
        private long   createDate;
        private long   updateDate;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTemplateNum() {
            return templateNum;
        }

        public void setTemplateNum(String templateNum) {
            this.templateNum = templateNum;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public long getCreateDate() {
            return createDate;
        }

        public void setCreateDate(long createDate) {
            this.createDate = createDate;
        }

        public long getUpdateDate() {
            return updateDate;
        }

        public void setUpdateDate(long updateDate) {
            this.updateDate = updateDate;
        }
    }


    public static class DazlleTemplateDeatil implements Serializable {
        private String id;
        private String userTemplateId;
        private String wheelNumber;
        private String wheelId;
        private String imgUrl;
        private int    bikeWheelNum;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUserTemplateId() {
            return userTemplateId;
        }

        public void setUserTemplateId(String userTemplateId) {
            this.userTemplateId = userTemplateId;
        }

        public String getWheelNumber() {
            return wheelNumber;
        }

        public void setWheelNumber(String wheelNumber) {
            this.wheelNumber = wheelNumber;
        }

        public String getWheelId() {
            return wheelId;
        }

        public void setWheelId(String wheelId) {
            this.wheelId = wheelId;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public int getBikeWheelNum() {
            return bikeWheelNum;
        }

        public void setBikeWheelNum(int bikeWheelNum) {
            this.bikeWheelNum = bikeWheelNum;
        }
    }
}
