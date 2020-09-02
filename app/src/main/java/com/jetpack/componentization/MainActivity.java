package com.jetpack.componentization;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.jetpack.componentization.ui.main.MainFragment;
import com.jetpack.componentization.ui.main.MainViewModel;

public class MainActivity extends AppCompatActivity {
    MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainViewModel=new ViewModelProvider(this).get(MainViewModel.class);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow();
        getLifecycle().addObserver(new LifecycleEventObserver() {
            @Override
            public void onStateChanged(@NonNull LifecycleOwner source, @NonNull Lifecycle.Event event) {
                Log.e("getLifecycle","=Lifecycle11111=event==>"+event);
            }
        });

    }

    public void ClickMyButton(View view) {
        final Button button= (Button) view;
        mainViewModel.setUserLiveData("1111111");
        mainViewModel.getUserLiveData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                button.setText(s);

            }
        });
        getLifecycle().addObserver(new LifecycleEventObserver() {
            @Override
            public void onStateChanged(@NonNull LifecycleOwner source, @NonNull Lifecycle.Event event) {
                Log.e("getLifecycle","=Lifecycle=event==>"+event);
            }
        });


    }

    public void ClickMyButton2(View view) {
        startActivity(new Intent(this,MainActivity2.class));
    }
}