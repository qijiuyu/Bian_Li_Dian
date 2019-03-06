package com.zxdc.http.library.bean;

import java.io.Serializable;
import java.util.List;
public class DazzleRecommendBean extends BaseBean{
    private DazzleRecommend data;

    public DazzleRecommend getData() {
        return data;
    }

    public void setData(DazzleRecommend data) {
        this.data = data;
    }
    public static class DazzleRecommend implements Serializable {
        private List<DazzleBean> defaultList;
        private List<DazzleBean> lovers;
        private List<DazzleBean> enjoyTour;
        private List<DazzleBean> mapleLeaves;
        private List<DazzleBean> iceSnows;
        private List<DazzleBean> recommends;

        public List<DazzleBean> getDefaultList() {
            return defaultList;
        }

        public void setDefaultList(List<DazzleBean> defaultList) {
            this.defaultList = defaultList;
        }

        public List<DazzleBean> getLovers() {
            return lovers;
        }

        public void setLovers(List<DazzleBean> lovers) {
            this.lovers = lovers;
        }

        public List<DazzleBean> getEnjoyTour() {
            return enjoyTour;
        }

        public void setEnjoyTour(List<DazzleBean> enjoyTour) {
            this.enjoyTour = enjoyTour;
        }

        public List<DazzleBean> getMapleLeaves() {
            return mapleLeaves;
        }

        public void setMapleLeaves(List<DazzleBean> mapleLeaves) {
            this.mapleLeaves = mapleLeaves;
        }

        public List<DazzleBean> getIceSnows() {
            return iceSnows;
        }

        public void setIceSnows(List<DazzleBean> iceSnows) {
            this.iceSnows = iceSnows;
        }

        public List<DazzleBean> getRecommends() {
            return recommends;
        }

        public void setRecommends(List<DazzleBean> recommends) {
            this.recommends = recommends;
        }
    }
}
