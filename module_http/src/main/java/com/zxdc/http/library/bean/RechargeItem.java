package com.zxdc.http.library.bean;

import java.io.Serializable;

/**
 * 充值模板
 */
public class RechargeItem implements Serializable {

    private String money;

    public RechargeItem (){};

    public RechargeItem(String money){
        this.money=money;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
