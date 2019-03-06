package com.zxdc.http.library.bean;

import java.io.Serializable;

public class BikeBean extends BaseBean {

    private BikeOrder data;

    public BikeOrder getData() {
        return data;
    }

    public void setData(BikeOrder data) {
        this.data = data;
    }

    public static class BikeOrder implements Serializable{
        //订单id
        private String order_id;
        //订单小号
        private String order_num;
        //imai号
        private long imei;
        //车辆编号
        private String bike_code;
        //车辆版本
        private String bike_ver;
        //开始计费时间
        private long open_time;
        //服务器时间
        private long sys_time=0;
        //纬度
        private double latitude;
        //经度
        private double longitude;
        //需要支付总金额
        private double money;
        //骑行时间,精确到分钟
        private long cycling_time;
        //用户最新余额(分)
        private double balance;
        //支付方式: 0，余额， 1，骑行券  2，集团账户
        private int pay_type;
        //支付状态: 0 未支付，1 支付成功，2 支付失败
        private int pay_status;
        //支付方式(1元/时)
        private String charge_type;
        //消耗大卡
        private int kilocalorie;
        //订单状态: 0，预约中， 1，已开锁，2，开始预约计费， 3，开始骑
        private int order_status;
        //红包类型的车辆   0:不是红包车    1：禁停区内的红包车
        private int redbike_flag;
        //运行区需要充值预付费
        private double price;
        //运营区内挪车费
        private int illegal_parking_price;
        //运营区外的挪车费
        private int out_area_price;

        public BikeOrder (){};

        public BikeOrder(String bike_code,double latitude,double longitude,int redbike_flag){
            this.bike_code=bike_code;
            this.latitude=latitude;
            this.longitude=longitude;
            this.redbike_flag=redbike_flag;
        }

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

        public long getImei() {
            return imei;
        }

        public void setImei(long imei) {
            this.imei = imei;
        }

        public String getBike_code() {
            return bike_code;
        }

        public void setBike_code(String bike_code) {
            this.bike_code = bike_code;
        }

        public String getBike_ver() {
            return bike_ver;
        }

        public void setBike_ver(String bike_ver) {
            this.bike_ver = bike_ver;
        }

        public long getOpen_time() {
            return open_time;
        }

        public void setOpen_time(long open_time) {
            this.open_time = open_time;
        }

        public long getSys_time() {
            return sys_time;
        }

        public void setSys_time(long sys_time) {
            this.sys_time = sys_time;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public double getMoney() {
            return money;
        }

        public void setMoney(double money) {
            this.money = money;
        }

        public long getCycling_time() {
            return cycling_time;
        }

        public void setCycling_time(long cycling_time) {
            this.cycling_time = cycling_time;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        public int getPay_type() {
            return pay_type;
        }

        public void setPay_type(int pay_type) {
            this.pay_type = pay_type;
        }

        public int getPay_status() {
            return pay_status;
        }

        public void setPay_status(int pay_status) {
            this.pay_status = pay_status;
        }

        public String getCharge_type() {
            return charge_type;
        }

        public void setCharge_type(String charge_type) {
            this.charge_type = charge_type;
        }

        public int getKilocalorie() {
            return kilocalorie;
        }

        public void setKilocalorie(int kilocalorie) {
            this.kilocalorie = kilocalorie;
        }

        public int getOrder_status() {
            return order_status;
        }

        public void setOrder_status(int order_status) {
            this.order_status = order_status;
        }

        public int getRedbike_flag() {
            return redbike_flag;
        }

        public void setRedbike_flag(int redbike_flag) {
            this.redbike_flag = redbike_flag;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getIllegal_parking_price() {
            return illegal_parking_price;
        }

        public void setIllegal_parking_price(int illegal_parking_price) {
            this.illegal_parking_price = illegal_parking_price;
        }

        public int getOut_area_price() {
            return out_area_price;
        }

        public void setOut_area_price(int out_area_price) {
            this.out_area_price = out_area_price;
        }
    }
}
