package com.jetpack.home;

import android.os.Bundle;

import com.dawn.lib_annotation.BindPath;
import com.jetpack.baselib.ToastUtil;

import androidx.appcompat.app.AppCompatActivity;


@BindPath(path="home/home")
public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ToastUtil.toast("11111");
    }
}
