package com.jetpack.home.life;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.jetpack.baselib.util.LifecycleManager;
import com.jetpack.baselib.util.LogUtil;
import com.jetpack.home.R;

public class LifecycleActivity extends AppCompatActivity {
    TextView textView;
    String string="111";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
        LogUtil.e("=LifecycleActivity==life==onCreate");
        textView=findViewById(R.id.life_text);
        textView.setText(string+"竖屏->横屏：onConfigurationChanged->onPause-onStop->onDestroy\n" +
                "onCreate->onStart->onRestoreInstanceState->onResume\n" +
                "再次切竖屏幕：onConfigurationChanged->onPause-onStop->onDestroy\n" +
                "onCreate->onStart->onRestoreInstanceState->onResume\n" +
                "单例模式下，再次跳转到此界面：onPause->onNewIntent->onResume");
        getLifecycle().addObserver(new LifecycleManager());

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        LogUtil.e("=LifecycleActivity==life==onNewIntent");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtil.e("=LifecycleActivity==life==onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtil.e("=LifecycleActivity==life==onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.e("=LifecycleActivity==life==onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtil.e("=LifecycleActivity==life==onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtil.e("=LifecycleActivity==life==onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.e("=LifecycleActivity==life==onDestroy");
    }

//    @Override
//    protected void onSaveInstanceState(@NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
//        LogUtil.e("=LifecycleActivity==life==onSaveInstanceState");
//    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        LogUtil.e("=LifecycleActivity==life==onRestoreInstanceState");
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        LogUtil.e("=LifecycleActivity==life==onConfigurationChanged==="+newConfig);
    }

    public void onClick(View view) {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setMessage("dialog");
        builder.show();
    }

    public void onClick1(View view) {
        Intent intent=new Intent(view.getContext(),TransparentActivity.class);
        startActivity(intent);
    }

    public void onClick2(View view) {
        Intent intent=new Intent(view.getContext(),LifecycleActivity.class);
        startActivity(intent);
    }

    public void onClick3(View view) {
        Intent intent=new Intent(view.getContext(),MainActivity.class);
        startActivity(intent);
    }
}