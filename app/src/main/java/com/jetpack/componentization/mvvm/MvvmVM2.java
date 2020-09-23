package com.jetpack.componentization.mvvm;

import android.view.View;

import androidx.databinding.ObservableField;

import com.jetpack.baselib.base.BaseViewModel;
import com.jetpack.baselib.base.RxLifeObserver;
import com.jetpack.lib_common.api.ApiRepository;

import java.io.IOException;

import okhttp3.ResponseBody;


public class MvvmVM2 extends BaseViewModel {
    public ObservableField<String> str=new ObservableField<>();
    public View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            request();
            request();
        }
    };

    private void request(){

        ApiRepository.checkAppResource("111", new RxLifeObserver<ResponseBody>(this) {
            @Override
            public void onNext(ResponseBody responseBody) {
                super.onNext(responseBody);
                try {
                    str.set(responseBody.string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
