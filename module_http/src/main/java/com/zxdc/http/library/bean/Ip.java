package com.zxdc.http.library.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/10/19 0019.
 */

public class Ip implements Serializable {
    private String name;

    private String ip;

    public Ip(){};

    public Ip(String name, String ip){
        this.name=name;
        this.ip=ip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
