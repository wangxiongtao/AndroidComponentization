package com.jetpack.componentization.mvvm;

import android.os.Bundle;

import com.jetpack.baselib.base.BaseActivity;
import com.jetpack.componentization.BR;
import com.jetpack.componentization.R;
import com.jetpack.componentization.databinding.ActivityMVVM2Binding;

public class MVVM2Activity extends BaseActivity<MvvmVM2, ActivityMVVM2Binding> {


    @Override
    public int getLayoutId() {
        return R.layout.activity_m_v_v_m2;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public int initVariableId() {
        return BR.vm2;
    }
}