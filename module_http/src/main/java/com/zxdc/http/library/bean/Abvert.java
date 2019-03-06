package com.zxdc.http.library.bean;


import java.io.Serializable;
import java.util.List;

/**
 * 广告类
 * Created by Administrator on 2017/5/11 0011.
 */

public class Abvert extends BaseBean implements Serializable {

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {
        private List<AdvertisementDeveloperVOBean> advertisementDeveloperVO;

        public List<AdvertisementDeveloperVOBean> getAdvertisementDeveloperVO() {
            return advertisementDeveloperVO;
        }

        public void setAdvertisementDeveloperVO(List<AdvertisementDeveloperVOBean> advertisementDeveloperVO) {
            this.advertisementDeveloperVO = advertisementDeveloperVO;
        }

        public static class AdvertisementDeveloperVOBean implements Serializable {
            private String id;
            private String platformName;
            private int dockingState;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getPlatformName() {
                return platformName;
            }

            public void setPlatformName(String platformName) {
                this.platformName = platformName;
            }

            public int getDockingState() {
                return dockingState;
            }

            public void setDockingState(int dockingState) {
                this.dockingState = dockingState;
            }
        }
    }
}
