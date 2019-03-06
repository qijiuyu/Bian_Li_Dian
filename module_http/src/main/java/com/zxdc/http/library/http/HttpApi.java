package com.zxdc.http.library.http;

import com.zxdc.http.library.bean.Abvert;
import com.zxdc.http.library.bean.Area;
import com.zxdc.http.library.bean.BaseBean;
import com.zxdc.http.library.bean.BikeBean;
import com.zxdc.http.library.bean.BikeList;
import com.zxdc.http.library.bean.DIYBean;
import com.zxdc.http.library.bean.DazzleMyUploadBean;
import com.zxdc.http.library.bean.DazzleOneTypeMoreBean;
import com.zxdc.http.library.bean.DazzleRecommendBean;
import com.zxdc.http.library.bean.News;
import com.zxdc.http.library.bean.NotPayOrder;
import com.zxdc.http.library.bean.TaskCoin;
import com.zxdc.http.library.bean.Token;
import com.zxdc.http.library.bean.UserBean;
import com.zxdc.http.library.bean.Version;
import com.zxdc.http.library.bean.AssetDetails;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface HttpApi {

    /**
     * 获取最新的accessToken
     */
    @FormUrlEncoded
    @POST(HttpConstant.GET_ACCESS_TOKEN)
    Call<Token> getAccessToken(@FieldMap Map<String, String> map);

}
