package com.jetpack.componentization.bean;

import android.view.View;
import android.widget.Button;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.ViewModel;

import com.jetpack.baselib.LogUtil;
import com.jetpack.baselib.ToastUtil;

public class UserViewModel extends ViewModel {
    public ObservableField<String> modelName=new ObservableField<>();
    public ObservableField<String> bindText=new ObservableField<>();
    public ObservableField<OrderBean>orderBean=new ObservableField<>();
    public ObservableField<String>editTextString=new ObservableField<>();
    public ObservableField<String>dataContent=new ObservableField<>();
    public ObservableInt dataSize=new ObservableInt();

    public void click(View view, int dddd){
        Button v= (Button) view;
        ToastUtil.toast("点击了=view===>"+v.getText().toString()+"----"+dddd);

    }
    public void click1(){
        ToastUtil.toast("点击了==111=>"+bindText.get());

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        LogUtil.e("=life=onCleared===>");
    }
}
