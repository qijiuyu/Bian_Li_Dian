package com.zxdc.http.library.http.base;

import com.zxdc.http.library.bean.Token;
import com.zxdc.http.library.http.HttpApi;
import com.zxdc.http.library.parameter.ParameterUtils;
import com.zxdc.utils.library.util.LogUtils;
import com.zxdc.utils.library.util.SPUtil;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
/**
 * HTTP拦截器
 * Created by lyn on 2017/4/13.
 */
public class LogInterceptor implements Interceptor {

    private final int ACCESS_TOKEN_TIME_OUT_CODE = 401;
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        long t1 = System.nanoTime();
        LogUtils.e(String.format("request %s on %s%n%s", request.url(), request.method(), request.headers()));
        if (request.method().equals("POST")) {
            request = addParameter(request);
        }
        Response response = chain.proceed(request);
        long t2 = System.nanoTime();
        String body = response.body().string();
        //如果ACCESS_TOKEN失效，自动重新获取一次
        final int code = getCode(body);
        if (code == ACCESS_TOKEN_TIME_OUT_CODE) {
            Token token = getAccessToken();
            if (token != null && token.isSussess()) {
                SPUtil.getInstance(Http.context).addString(SPUtil.TOKEN,token.getData());
                request = addParameter(request);
                response = chain.proceed(request);
                body = response.body().string();
            }
        }
        LogUtils.e(String.format("response %s in %.1fms%n%s", response.request().url(), (t2 - t1) / 1e6d, body));
        return response.newBuilder().body(ResponseBody.create(response.body().contentType(), body)).build();
    }

    /**
     * 获取AccessToken
     */
    public Token getAccessToken() throws IOException {
        Map<String, String> map = new HashMap<>();
        map.put("user_id", SPUtil.getInstance(Http.context).getString(SPUtil.USER_ID));
        map = ParameterUtils.getParameter(Http.context,map,2);
        final Token token = Http.getRetrofitNoInterceptor().create(HttpApi.class).getAccessToken(map).execute().body();
        return token;
    }

    /***
     * 添加公共参数
     */
    public Request addParameter(Request request) throws IOException {
        FormBody.Builder bodyBuilder = new FormBody.Builder();
        FormBody formBody;
        Map<String, String> requstMap = new HashMap<>();
        if (request.body().contentLength() > 0 && request.body() instanceof FormBody) {
            formBody = (FormBody) request.body();
            //把原来的参数添加到新的构造器，（因为没找到直接添加，所以就new新的）
            for (int i = 0; i < formBody.size(); i++) {
                  requstMap.put(formBody.name(i), formBody.value(i));
                  LogUtils.e(request.url() + "参数:" + formBody.name(i) + "=" + formBody.value(i));
            }
        }
        requstMap = ParameterUtils.getParameter(Http.context,requstMap,1);
        //添加公共参数
        for (String key : requstMap.keySet()) {
            bodyBuilder.addEncoded(key, requstMap.get(key));
        }
        formBody = bodyBuilder.build();
        request = request.newBuilder().post(formBody).build();
        return request;
    }

    public int getCode(String json) {
        int code = 0;
        try {
            JSONObject jsonObject = new JSONObject(json);
            if (jsonObject.has("code")) {
                code = jsonObject.getInt("code");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return code;
    }

}
