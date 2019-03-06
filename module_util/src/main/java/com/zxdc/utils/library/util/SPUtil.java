package com.zxdc.utils.library.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;

import com.google.gson.Gson;

import java.util.List;

public class SPUtil {

    public static String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

    public static char pad = '=';

    //是否是第一次打开APP
    public final static String IS_FIRST_OPEN="IS_FIRST_OPEN";
    //用户信息
    public final static String USERINFO="USERINFO";
    //token数据
    public final static String TOKEN="TOKEN";
    //用户id
    public final static String USER_ID="USER_ID";
    //当前定位的经纬度
    public final static String LOCATION_LAT="LOCATION_LAT";
    public final static String LOCATION_LONG="LOCATION_LONG";
    //保存要发送的蓝牙命令类型
    public final static String SEND_BLE_STATUS="SEND_BLE_STATUS";
    //蓝牙的mac地址
    public final static String DEVICE_MAC="DEVICE_MAC";
    //计算骑行距离的经纬度
    public final static String CYCLING_LAT="CYCLING_LAT";
    public final static String CYCLING_LON="CYCLING_LON";
    //骑行总距离
    public final static String TOTAL_DISTANCE="TOTAL_DISTANCE";
    //是否已临时锁车
    public final static String IS_CLOSE_LOCK="IS_CLOSE_LOCK";
    //是否首次开启旋轮
    public final static String IS_OPEN_DAZZLE="IS_OPEN_DAZZLE";
    //广告对象
    public final static String ABVERT="ABVERT";
    //是否第一次进入找茬游戏
    public final static String IS_OPEN_GAME_TASK="IS_OPEN_GAME_TASK";
    private SharedPreferences shar;
    private Editor editor;
    public final static String USERMESSAGE = "zxdc";
    private static SPUtil sharUtil = null;
    public static Gson gson=new Gson();
    @SuppressLint("WrongConstant")
    private SPUtil(Context context, String sharname) {
        shar = context.getSharedPreferences(sharname, Context.MODE_PRIVATE + Context.MODE_APPEND);
        editor = shar.edit();
    }

    public static SPUtil getInstance(Context context) {
        if (null == sharUtil) {
            sharUtil = new SPUtil(context, USERMESSAGE);
        }
        return sharUtil;
    }


    //添加String信息
    public void addString(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }

    //添加int信息
    public void addInt(String key, Integer value) {
        editor.putInt(key, value);
        editor.commit();
    }

    //添加boolean信息
    public void addBoolean(String key, boolean value) {
        editor.putBoolean(key, value);
        editor.commit();
    }

    //添加float信息
    public void addFloat(String key, float value) {
        editor.putFloat(key, value);
        editor.commit();
    }

    //添加long信息
    public void addLong(String key, long value) {
        editor.putLong(key, value);
        editor.commit();
    }

    //添加list
    public void addList(String key, List<Object> list) {
        editor.putString(key, gson.toJson(list));
        LogUtils.e(gson.toJson(list));
        editor.commit();
    }


    public void addObject(String key,Object object){
        editor.putString(key,gson.toJson(object));
        editor.commit();
    }


    public Object getObject(String key,Class myClass){
        final String value=shar.getString(key,null);
        if(!TextUtils.isEmpty(value)){
            return gson.fromJson(value,myClass);
        }
        return null;
    }


    public void removeMessage(String delKey) {
        editor.remove(delKey);
        editor.commit();
    }

    public void removeAll() {
        editor.clear();
        editor.commit();
    }

    public String getString(String key) {
        return shar.getString(key, "");
    }

    public Integer getInteger(String key) {
        return shar.getInt(key, 0);
    }

    public boolean getBoolean(String key) {
        return shar.getBoolean(key, false);
    }

    public float getFloat(String key) {
        return shar.getFloat(key, 0);
    }

    public long getLong(String key) {
        return shar.getLong(key, 0);
    }

}
