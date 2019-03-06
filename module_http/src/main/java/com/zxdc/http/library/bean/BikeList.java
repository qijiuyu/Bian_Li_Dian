package com.zxdc.http.library.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 查询附近车辆的类对象
 */
public class BikeList extends BaseBean {

    private List<BikeInfo> data;

    public List<BikeInfo> getData() {
        return data;
    }

    public void setData(List<BikeInfo> data) {
        this.data = data;
    }

    public static class BikeInfo implements Serializable{
        //车辆id
        private String bike_id;
        //七位车辆编码
        private String bike_code;
        //维度
        private double latitude;
        //经度
        private double longitude;
        //imei号，用于蓝牙
        private String imei;
        //运行区id
        private String area_id;
        //运行区code
        private String area_code;
        //该车什么类型的红包车
        private int redbike_flag;

        public String getBike_id() {
            return bike_id;
        }

        public void setBike_id(String bike_id) {
            this.bike_id = bike_id;
        }

        public String getBike_code() {
            return bike_code;
        }

        public void setBike_code(String bike_code) {
            this.bike_code = bike_code;
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

        public String getImei() {
            return imei;
        }

        public void setImei(String imei) {
            this.imei = imei;
        }

        public String getArea_id() {
            return area_id;
        }

        public void setArea_id(String area_id) {
            this.area_id = area_id;
        }

        public String getArea_code() {
            return area_code;
        }

        public void setArea_code(String area_code) {
            this.area_code = area_code;
        }

        public int getRedbike_flag() {
            return redbike_flag;
        }

        public void setRedbike_flag(int redbike_flag) {
            this.redbike_flag = redbike_flag;
        }
    }
}
