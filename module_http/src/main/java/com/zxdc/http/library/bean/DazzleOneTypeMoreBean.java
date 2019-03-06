package com.zxdc.http.library.bean;

import java.util.List;

public class DazzleOneTypeMoreBean extends BaseBean {
    private List<DazzleBean> data;

    public List<DazzleBean> getData() {
        return data;
    }

    public void setData(List<DazzleBean> data) {
        this.data = data;
    }
}
