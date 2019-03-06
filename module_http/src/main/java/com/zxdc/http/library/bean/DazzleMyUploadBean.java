package com.zxdc.http.library.bean;
import java.util.List;

public class DazzleMyUploadBean extends BaseBean{
    private List<AuditDazzleBean> data;

    public List<AuditDazzleBean> getData() {
        return data;
    }

    public void setData(List<AuditDazzleBean> data) {
        this.data = data;
    }
}
