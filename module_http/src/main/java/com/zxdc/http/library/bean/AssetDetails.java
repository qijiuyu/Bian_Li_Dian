package com.zxdc.http.library.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 提现明细
 */
public class AssetDetails extends BaseBean {

    private TBean data;

    public TBean getData() {
        return data;
    }

    public void setData(TBean data) {
        this.data = data;
    }

    public static class TBean implements Serializable{
        private List<ListDetails> t=new ArrayList<>();

        public List<ListDetails> getT() {
            return t;
        }

        public void setT(List<ListDetails> t) {
            this.t = t;
        }
    }

    public static class ListDetails implements Serializable{
        //订单号
        private String id;
        //1:充值 2:提现退款，3:红包
        private String type;
        //日期
        private long date;
        //金额
        private double amount;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public long getDate() {
            return date;
        }

        public void setDate(long date) {
            this.date = date;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }
    }
}
