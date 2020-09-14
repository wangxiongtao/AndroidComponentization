package com.jetpack.componentization.jetpack;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ObservableField;

import com.jetpack.componentization.bean.UserBean;
import com.jetpack.componentization.databinding.ActivityDataBindBinding;

public class DataBindActivity extends AppCompatActivity {
  ObservableField<String> text=new ObservableField<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDataBindBinding bindBinding=ActivityDataBindBinding.inflate(getLayoutInflater());
        setContentView(bindBinding.getRoot());
        UserBean userBean=new UserBean();
        UserBean userBean1=new UserBean();
        bindBinding.setUserBean(userBean);
        userBean.name="数据绑定";



        userBean1.name2.set("数据绑定1");
        bindBinding.setUserBean1(userBean1);



        text.set("数据绑定");
        bindBinding.setBindText(text.get());


        bindBinding.bindBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userBean.setName("双向数据绑定");
                userBean1.name2.set("双向数据绑定1");
                text.set("自定义双向数据绑定");

            }
        });
    }
}