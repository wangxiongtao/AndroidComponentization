package com.jetpack.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.jetpack.baselib.ToastUtil;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ToastUtil.toast(this,"11111");
    }
}
