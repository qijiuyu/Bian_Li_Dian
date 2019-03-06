package com.zxdc.utils.library.util;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.zxdc.utils.library.R;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * @author Administrator
 */
public class Util extends ClassLoader {

    static double DEF_PI = 3.14159265359; // PI
    static double DEF_2PI = 6.28318530712; // 2*PI
    static double DEF_PI180 = 0.01745329252; // PI/180.0
    static double DEF_R = 6370693.5; // radius of earth
    static ProgressDialog progressDialog = null;

    /**
     * 计算两对经纬度的距离
     *
     * @param lon1
     * @param lat1
     * @param lon2
     * @param lat2
     * @return
     */
    public static double GetShortDistance(double lon1, double lat1, double lon2, double lat2) {
        double ew1, ns1, ew2, ns2;
        double dx, dy, dew;
        double distance;
        // 角度转换为弧度
        ew1 = lon1 * DEF_PI180;
        ns1 = lat1 * DEF_PI180;
        ew2 = lon2 * DEF_PI180;
        ns2 = lat2 * DEF_PI180;
        // 经度差
        dew = ew1 - ew2;
        // 若跨东经和西经180 度，进行调整
        if (dew > DEF_PI)
            dew = DEF_2PI - dew;
        else if (dew < -DEF_PI)
            dew = DEF_2PI + dew;
        dx = DEF_R * Math.cos(ns1) * dew; // 东西方向长度(在纬度圈上的投影长度)
        dy = DEF_R * (ns1 - ns2); // 南北方向长度(在经度圈上的投影长度)
        // 勾股定理求斜边长
        distance = Math.sqrt(dx * dx + dy * dy);
        System.out.println(distance);
        return distance;
    }


    /**
     * 判断是否输入表情符号
     * @param string
     * @return
     */
    public static boolean isEmoji(String string) {
        Pattern p = Pattern.compile("[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]",
                Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(string);
        return m.find();
    }


    /**
     * 保留小数的double数据
     * @param d
     * @return
     */
    public static String setDouble(double d,int type){
        DecimalFormat df=null;
        switch (type){
            case 0:
                df = new DecimalFormat("0");
                break;
            case 1:
                df = new DecimalFormat("0.0");
                break;
            case 2:
                df = new DecimalFormat("0.00");
                break;
            case 3:
                df = new DecimalFormat("0.000");
                break;
            case 4:
                df = new DecimalFormat("0.0000");
                break;
        }
        return df.format(d);
    }


    /**
     * 只允许字母、数字和汉字
     * @param str
     * @return
     * @throws PatternSyntaxException
     */
    public static boolean stringFilter(String str)throws PatternSyntaxException {
        String   regEx  =  "^[\\u4e00-\\u9fa5*a-zA-Z0-9]+$";
        Pattern   p   =   Pattern.compile(regEx);
        Matcher   m   =   p.matcher(str);
        return   m.matches();
    }


    /**
     * 获取当前系统的版本号
     *
     * @return
     */
    public static int getVersionCode(Context mContext) {
        try {
            // 获取packagemanager的实例
            PackageManager packageManager = mContext.getPackageManager();
            // getPackageName()是你当前类的包名，0代表是获取版本信息
            PackageInfo packInfo = packageManager.getPackageInfo(mContext.getPackageName(), 0);
            int version = packInfo.versionCode;
            return version;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


    /**
     * 获取当前系统的版本名称
     *
     * @return
     */
    public static String getVersionName(Context mContext) {
        try {
            // 获取packagemanager的实例
            PackageManager packageManager = mContext.getPackageManager();
            // getPackageName()是你当前类的包名，0代表是获取版本信息
            PackageInfo packInfo = packageManager.getPackageInfo(mContext.getPackageName(), 0);
            String version = packInfo.versionName;
            return version;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    /**
     * 获取渠道名称
     * @return
     */
    public static String getChannel(Context mContext){
        final ApplicationInfo appInfo;
        try {
            appInfo = mContext.getPackageManager().getApplicationInfo(mContext.getPackageName(), PackageManager.GET_META_DATA);
            final String utmSource = appInfo.metaData.get("SENSORS_ANALYTICS_UTM_SOURCE")+"";
            return utmSource;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 设备唯一id
     * @param context
     * @return
     */
    public static String getDeviceId(Context context){
        final TelephonyManager telephonyMgr = (TelephonyManager) context.getSystemService(context.TELEPHONY_SERVICE);
        //设备唯一id
        return telephonyMgr.getDeviceId();
    }


    /**
     * 获取屏幕宽高
     * @param context
     * @param type
     * @return
     */
    public static int getDeviceWH(Context context,int type){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();
        if(type==1){
            return width;
        }else{
            return height;
        }
    }


    /**
     *获取状态栏高度
     * @param context
     * @return
     */
    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }


    /*
     * 设置控件所在的位置YY，并且不改变宽高，
     * XY为绝对位置
     */
    public static void setLayout(View view, int x, int y) {
        ViewGroup.MarginLayoutParams margin=new ViewGroup.MarginLayoutParams(view.getLayoutParams());
        margin.setMargins(x,y, x+margin.width, y+margin.height);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(margin);
        view.setLayoutParams(layoutParams);
    }


    /**
     * loding弹框
     * @param msgId
     * @param isClose
     */
    public static void showProgress(Activity activity,int msgId,boolean isClose) {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.setMessage(activity.getString(msgId));
            return;
        }
        progressDialog = new ProgressDialog(activity);
        progressDialog.setMessage(activity.getString(msgId));
        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(isClose);
        progressDialog.show();
    }


    /**
     * 取消进度条
     */
    public static void closeProgress() {
        if (progressDialog != null && progressDialog.isShowing()){
            progressDialog.dismiss();
        }
    }


    /**
     * 展示Toast提示
     * @param msg
     */
    public static void showMsg(Activity activity, String msg){
        Toast.makeText(activity,msg, Toast.LENGTH_SHORT).show();
    }

    public static void showId(Activity activity, int msgId){
        Toast.makeText(activity,activity.getString(msgId), Toast.LENGTH_SHORT).show();
    }


    /**
     * dialog弹框
     * @param activity
     * @param view
     * @return
     */
    public static Dialog getDialog(Activity activity, View view){
        final Dialog dialog = new Dialog(activity, R.style.ActionSheetDialogStyle);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setTitle(null);
        dialog.setCancelable(true);
        dialog.setContentView(view);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        Window window = dialog.getWindow();
        window.setGravity(Gravity.CENTER);  //此处可以设置dialog显示的位置
        window.setWindowAnimations(R.style.mystyle);  //添加动画
        dialog.show();
        return dialog;
    }
}
