package com.jetpack.componentization.mvvm;

import android.content.Intent;
import android.view.View;

import androidx.databinding.ObservableField;

import com.jetpack.baselib.base.BaseViewModel;
import com.jetpack.baselib.base.RxLifeObserver;
import com.jetpack.lib_common.api.ApiRepository;

import java.io.IOException;

import okhttp3.ResponseBody;


public class MvvmVM extends BaseViewModel {
    public ObservableField<String> str=new ObservableField<>();
    public View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            request();
            request();
        }
    };
    public View.OnClickListener listener1=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(v.getContext(),MVVM2Activity.class);
            v.getContext().startActivity(intent);
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
