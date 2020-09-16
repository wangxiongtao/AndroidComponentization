package com.jetpack.componentization.jetpack;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.jetpack.baselib.LogUtil;
import com.jetpack.baselib.ToastUtil;
import com.jetpack.componentization.R;
import com.jetpack.componentization.bean.OrderBean;
import com.jetpack.componentization.bean.UserBean;
import com.jetpack.componentization.bean.UserViewModel;
import com.jetpack.componentization.databinding.ActivityDataBindBinding;

public class DataBindActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDataBindBinding bindBinding=DataBindingUtil.setContentView(this, R.layout.activity_data_bind);
        bindBinding.setLifecycleOwner(this);
        UserBean userBean=new UserBean();
        UserBean userBean1=new UserBean();
        bindBinding.setUserBean(userBean);
        userBean.name="数据绑定 @{}：表示单向绑定 @={}表示双向绑定，双向绑定一般需要自己实现，要实现两个方法";



        userBean1.name2.set("数据绑定1");
        bindBinding.setUserBean1(userBean1);






        UserViewModel userViewModel= new ViewModelProvider(this).get(UserViewModel.class);
        userViewModel.modelName.set("使用viewmodel数据绑定");
        userViewModel.bindText.set("使用viewmodel自定义数据绑定");

        OrderBean orderBean=new OrderBean();
        orderBean.str="使用viewmodel中引用另外一个类的数据绑定";
        userViewModel.orderBean.set(orderBean);
        userViewModel.editTextString.set("输入绑定");
        userViewModel.dataContent.set("自定义view属性输入绑定");
        userViewModel.dataSize.set(10);
        bindBinding.setUserModel(userViewModel);







        bindBinding.bindBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userBean.setName("双向数据绑定");
                userBean1.name2.set("双向数据绑定1");
                userViewModel.modelName.set("使用viewmodel双向数据绑定");
                userViewModel.bindText.set("使用viewmodel自定义双向数据绑定");


                OrderBean orderBean1=new OrderBean();
                orderBean1.str="使用viewmodel中引用另外一个类的双向数据绑定";
                userViewModel.orderBean.set(orderBean1);
                ToastUtil.toast(userViewModel.editTextString.get());
                ToastUtil.toast(userViewModel.dataContent.get());

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.e("=life=onDestroy===>");
    }
}