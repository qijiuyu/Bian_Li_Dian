package com.zxdc.http.library.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 禁停区，禁行区，骑行区
 */
public class Area extends BaseBean {

    private List<AreaList> data;

    public List<AreaList> getData() {
        return data;
    }

    public void setData(List<AreaList> data) {
        this.data = data;
    }

    public static class AreaList implements Serializable{

        //0禁停区，1骑行区，2禁行区，3停放区，4扩展类型
        private int type;
        //中心点经纬度
        private double center_long;
        private double center_lati;
        //区域坐标点
        private List<List<Double>> vertex_loc=new ArrayList<>();

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public double getCenter_long() {
            return center_long;
        }

        public void setCenter_long(double center_long) {
            this.center_long = center_long;
        }

        public double getCenter_lati() {
            return center_lati;
        }

        public void setCenter_lati(double center_lati) {
            this.center_lati = center_lati;
        }

        public List<List<Double>> getVertex_loc() {
            return vertex_loc;
        }

        public void setVertex_loc(List<List<Double>> vertex_loc) {
            this.vertex_loc = vertex_loc;
        }
    }
}
