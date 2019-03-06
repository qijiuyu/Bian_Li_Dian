package com.zxdc.http.library.http;

import android.os.Handler;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.zxdc.http.library.bean.Abvert;
import com.zxdc.http.library.bean.Area;
import com.zxdc.http.library.bean.BaseBean;
import com.zxdc.http.library.bean.BikeBean;
import com.zxdc.http.library.bean.BikeList;
import com.zxdc.http.library.bean.DIYBean;
import com.zxdc.http.library.bean.DazzleMyUploadBean;
import com.zxdc.http.library.bean.DazzleOneTypeMoreBean;
import com.zxdc.http.library.bean.DazzleRecommendBean;
import com.zxdc.http.library.bean.DownLoad;
import com.zxdc.http.library.bean.News;
import com.zxdc.http.library.bean.NotPayOrder;
import com.zxdc.http.library.bean.TaskCoin;
import com.zxdc.http.library.bean.Token;
import com.zxdc.http.library.bean.UploadFile;
import com.zxdc.http.library.bean.UserBean;
import com.zxdc.http.library.bean.Version;
import com.zxdc.http.library.bean.AssetDetails;
import com.zxdc.http.library.http.base.BaseRequst;
import com.zxdc.http.library.http.base.Http;
import com.zxdc.utils.library.util.LogUtils;
import com.zxdc.utils.library.util.SPUtil;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HttpMethod extends BaseRequst {

    /**
     * 获取最新的accessToken
     */
    public static void getAccessToken(String user_id, final Handler handler) {
        Map<String, String> map = new HashMap<>();
        map.put("user_id", user_id);
        Http.getRetrofit().create(HttpApi.class).getAccessToken(map).enqueue(new Callback<Token>() {
            public void onResponse(Call<Token> call, Response<Token> response) {
                BaseRequst.sendMessage(handler, HandlerConstant.GET_ACCESS_TOKEN_SUCCESS, response.body());
            }
            public void onFailure(Call<Token> call, Throwable t) {
                BaseRequst.sendMessage(handler, HandlerConstant.REQUST_ERROR, null);
            }
        });
    }
}
