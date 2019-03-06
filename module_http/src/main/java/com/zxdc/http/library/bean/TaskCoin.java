package com.zxdc.http.library.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 任务金币
 */
public class TaskCoin extends BaseBean {

    private TaskCoinList data;

    public TaskCoinList getData() {
        return data;
    }

    public void setData(TaskCoinList data) {
        this.data = data;
    }

    public static class TaskCoinList implements Serializable{
        private int coinNum=0;
        private List<TaskBean> list;

        public int getCoinNum() {
            return coinNum;
        }

        public void setCoinNum(int coinNum) {
            this.coinNum = coinNum;
        }

        public List<TaskBean> getList() {
            return list;
        }

        public void setList(List<TaskBean> list) {
            this.list = list;
        }
    }


    public static class TaskBean implements Serializable{
        private String id;
        private String userId;
        private String wisdomName;
        private int addAndSub;
        private int source;
        private int score;
        private int status;
        private long createDate;
        private long updateDate;
        private int version;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getWisdomName() {
            return wisdomName;
        }

        public void setWisdomName(String wisdomName) {
            this.wisdomName = wisdomName;
        }

        public int getAddAndSub() {
            return addAndSub;
        }

        public void setAddAndSub(int addAndSub) {
            this.addAndSub = addAndSub;
        }

        public int getSource() {
            return source;
        }

        public void setSource(int source) {
            this.source = source;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
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

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }
    }
}
