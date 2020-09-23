package com.jetpack.componentization.mvvm;

import android.os.Bundle;

import com.jetpack.baselib.base.BaseActivity;
import com.jetpack.componentization.BR;
import com.jetpack.componentization.R;
import com.jetpack.componentization.databinding.ActivityMVVMBinding;

public class MVVMActivity extends BaseActivity<MvvmVM, ActivityMVVMBinding>{

    @Override
    public int getLayoutId() {
        return R.layout.activity_m_v_v_m;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public int initVariableId() {
        return BR.vm2;
    }
}