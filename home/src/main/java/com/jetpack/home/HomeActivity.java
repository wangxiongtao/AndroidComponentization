package com.jetpack.home;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.dawn.lib_annotation_compile.BindPath;
import com.jetpack.baselib.ToastUtil;


@BindPath(path="home/home")
public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ToastUtil.toast("11111");
    }
}
