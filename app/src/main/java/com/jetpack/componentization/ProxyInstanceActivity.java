package com.jetpack.componentization;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.jetpack.baselib.util.LogUtil;
import com.jetpack.baselib.util.ToastUtil;
import com.jetpack.componentization.util.proxy.ProxyClient;
import com.jetpack.componentization.util.proxy.ProxyInterface;
import com.jetpack.lib_common.api.ApiRepository;

public class ProxyInstanceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proxy_instance);
        int a=new ProxyClient().create(ProxyInterface.class).toProxy("11111");
        ToastUtil.toast("return===>"+a);
    }

    public void toLiveData(View view) {
        ApiRepository.checkAppResource1("11").observe(ProxyInstanceActivity.this, (f)->{
            try {
                LogUtil.e("===>observe===>"+f.string());
            } catch (Exception e) {
                e.printStackTrace();
                LogUtil.e("===>observe=IOException==>"+e.getLocalizedMessage());
            }


        });
    }

    public void btnClick(View view) {
        Integer integer= ApiRepository.checkAppResource2("1111");
        LogUtil.e("===>btnClick==>"+integer);
    }
}