package com.jetpack.componentization.bean;

import androidx.databinding.ObservableField;
import androidx.lifecycle.ViewModel;

import com.jetpack.baselib.ToastUtil;

public class UserViewModel extends ViewModel {
    public ObservableField<String> modelName=new ObservableField<>();
    public ObservableField<String> bindText=new ObservableField<>();
    public ObservableField<OrderBean>orderBean=new ObservableField<>();
    public void click(){
        ToastUtil.toast("点击了===>"+bindText.get());

    }
}
