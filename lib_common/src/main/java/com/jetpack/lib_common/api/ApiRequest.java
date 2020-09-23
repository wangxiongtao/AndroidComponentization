package com.jetpack.lib_common.api;

import androidx.lifecycle.LiveData;

import com.jetpack.lib_common.http.HttpManager;
import com.jetpack.lib_common.model.Model;

import io.reactivex.Observer;
import okhttp3.ResponseBody;

public class ApiRequest {
    public static void checkAppResource(String time,Observer<ResponseBody> observer) {
        Model.get(HttpManager.getInstance()
                .getApiInterface()
                .checkAppResource(time)).subscribe(observer);
    }
    public static LiveData<ResponseBody> checkAppResource1(String time) {
        return HttpManager.getInstance().getApiInterface().checkAppResource1(time);
    }
    public static Integer checkAppResource2(String time) {
        return HttpManager.getInstance().getApiInterface().checkAppResource2("123");
    }

}
