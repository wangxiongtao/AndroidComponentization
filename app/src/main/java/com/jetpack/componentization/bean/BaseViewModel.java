package com.jetpack.componentization.bean;

import androidx.lifecycle.ViewModel;

import com.jetpack.lib_common.api.ApiInterface;
import com.jetpack.lib_common.http.HttpManager;

public class BaseViewModel extends ViewModel {
    public ApiInterface getApiInterface(){
        return  HttpManager.get();
    }

}
