package com.zxdc.http.library.parameter;

import android.content.Context;
import android.text.TextUtils;
import com.zxdc.utils.library.util.SPUtil;
import com.zxdc.utils.library.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

/**
 * 公共参数
 * Created by Administrator on 2017/2/4 0004.
 */
public class ParameterUtils {

    public static Map<String, String> getParameter(Context context,Map<String, String> map,int type) {
        map.put("device_id", Util.getDeviceId(context));
        map.put("os_name", "Android");
        map.put("app_version", String.valueOf(Util.getVersionCode(context)));
        map.put("app_latitude", SPUtil.getInstance(context).getString(SPUtil.LOCATION_LAT));
        map.put("app_longitude", SPUtil.getInstance(context).getString(SPUtil.LOCATION_LONG));
        map.put("token", SPUtil.getInstance(context).getString(SPUtil.TOKEN));
        map.put("coord_type","GCJ02");
        //排序
        final List<Map.Entry<String, String>> infos = new ArrayList<Map.Entry<String, String>>(map.entrySet());
        // 重写集合的排序方法：按字母顺序
        Collections.sort(infos, new Comparator<Map.Entry<String, String>>() {
            public int compare(final Map.Entry<String, String> o1, final Map.Entry<String, String> o2) {
                return (o1.getKey().toString().compareTo(o2.getKey()));
            }
        });

        StringBuilder buf = new StringBuilder();
        for (Map.Entry<String, String> item : infos) {
             if (TextUtils.isEmpty(item.getValue())) {
                 item.setValue("");
             }
             buf.append(item.getKey() + "=" + item.getValue()+"&");
        }
        String data = buf.substring(0, buf.toString().length() - 1);
        final String skey = "9K%^JNCQtb*eKh#b";
        //加密
        try {
            byte[] encryptResultStr = BackAES.encrypt(data, skey, 1);
            if(type==1){
                map.put("signature", new String(encryptResultStr).replace("+","%2B"));
            }else{
                map.put("signature", new String(encryptResultStr));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

}
