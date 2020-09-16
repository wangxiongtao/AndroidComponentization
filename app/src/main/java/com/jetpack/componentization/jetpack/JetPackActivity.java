package com.jetpack.componentization.jetpack;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.jetpack.baselib.util.LifecycleManager;
import com.jetpack.baselib.util.ToastUtil;
import com.jetpack.componentization.databinding.ActivityJetPackBinding;


public class JetPackActivity extends AppCompatActivity {
    ActivityJetPackBinding jetPackBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        jetPackBinding = ActivityJetPackBinding.inflate(getLayoutInflater());
        View view = jetPackBinding.getRoot();
        setContentView(view);
        getLifecycle().addObserver(new LifecycleManager());
        jetPackBinding.jetPackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtil.toast("==jetPackBinding===>");
                Intent intent=new Intent(v.getContext(),DataBindActivity.class);
                startActivity(intent);
            }
        });
    }
}