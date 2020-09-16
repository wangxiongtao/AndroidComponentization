package com.jetpack.lib_common.http;


import com.jetpack.baselib.util.LogUtil;
import com.jetpack.lib_common.BuildConfig;
import com.jetpack.lib_common.api.ApiInterface;
import com.jetpack.lib_common.api.HeadInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import static okhttp3.logging.HttpLoggingInterceptor.Level.BODY;

/**
 * Created by fw-soc on 2018/9/19.
 */

public class HttpManager {
    private Retrofit retrofit;
    //    private HttpCallBack callBack;
    private static String sAPIBASEURL="https://api.stage.shenzhoubb.com/";
    private static Interceptor sHEADINTERCEPTOR;
    private ApiInterface apiInterface;


    private static class SingletonHolder {
        private static HttpManager instance = new HttpManager();
    }

    public static HttpManager getInstance() {
        return SingletonHolder.instance;
    }

    private OkHttpClient getOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)//设置读取超时时间
                .writeTimeout(30, TimeUnit.SECONDS)//设置写的超时时间
                .connectTimeout(30, TimeUnit.SECONDS)//设置连接超时时间
                .addInterceptor(new HeadInterceptor());
        if (BuildConfig.DEBUG) {
            builder.addInterceptor(new HttpLoggingInterceptor().setLevel(BODY));
        }
        return builder.build();

    }

    private HttpManager() {
//       测试 http://47.92.94.122:8080
//        正式 https://api.shenzhoubb.com
//        后台 http://192.168.200.6:8090
        retrofit = new Retrofit.Builder()
                .baseUrl(sAPIBASEURL)
//                .addConverterFactory(FastJsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(getOkHttpClient())
               .build();
        apiInterface=retrofit.create(ApiInterface.class);
        LogUtil.e("==API_BASE_URL====>" + sAPIBASEURL);
    }


    public static void initApiBaseUrl(String url) {
        sAPIBASEURL = url;
    }

    public ApiInterface getApiInterface() {
        return apiInterface;
    }

    public static void addHeadInterceptor(Interceptor headInterceptor) {
        sHEADINTERCEPTOR = headInterceptor;
    }

    public static ApiInterface get(){
        return HttpManager.getInstance().getApiInterface();
    }
}
