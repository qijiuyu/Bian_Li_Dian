package com.zxdc.http.library.bean;

import java.io.Serializable;
import java.util.List;

public class DazzleListBean implements Serializable {
    private String           type;
    private String           typeID;
    private List<DazzleBean> mDazzleBeans;

    public String getTypeID() {
        return typeID;
    }

    public void setTypeID(String typeID) {
        this.typeID = typeID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<DazzleBean> getDazzleBeans() {
        return mDazzleBeans;
    }

    public void setDazzleBeans(List<DazzleBean> dazzleBeans) {
        mDazzleBeans = dazzleBeans;
    }
}
