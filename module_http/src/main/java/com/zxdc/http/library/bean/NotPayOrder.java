package com.zxdc.http.library.bean;

import java.io.Serializable;

/**
 * 未支付订单
 */
public class NotPayOrder extends BaseBean {

    private NotPayBean data;

    public NotPayBean getData() {
        return data;
    }

    public void setData(NotPayBean data) {
        this.data = data;
    }

    public static class NotPayBean implements Serializable{

        //订单id
        private String order_id;
        //骑行单小号
        private String order_num;
        //车辆编号
        private String bike_code;
        //骑行单创建时间
        private long create_time;
        //骑行单开始时间
        private long open_time;
        //骑行单结束时间
        private long close_time;
        ////创建方式: 0，预约，1，扫码
        private int order_type;
        //需要支付金额
        private double money;

        public String getOrder_id() {
            return order_id;
        }

        public void setOrder_id(String order_id) {
            this.order_id = order_id;
        }

        public String getOrder_num() {
            return order_num;
        }

        public void setOrder_num(String order_num) {
            this.order_num = order_num;
        }

        public String getBike_code() {
            return bike_code;
        }

        public void setBike_code(String bike_code) {
            this.bike_code = bike_code;
        }

        public long getCreate_time() {
            return create_time;
        }

        public void setCreate_time(long create_time) {
            this.create_time = create_time;
        }

        public long getOpen_time() {
            return open_time;
        }

        public void setOpen_time(long open_time) {
            this.open_time = open_time;
        }

        public long getClose_time() {
            return close_time;
        }

        public void setClose_time(long close_time) {
            this.close_time = close_time;
        }

        public int getOrder_type() {
            return order_type;
        }

        public void setOrder_type(int order_type) {
            this.order_type = order_type;
        }

        public double getMoney() {
            return money;
        }

        public void setMoney(double money) {
            this.money = money;
        }
    }
}
