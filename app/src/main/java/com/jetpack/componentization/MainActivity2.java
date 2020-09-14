package com.jetpack.componentization;

import android.os.Bundle;

import com.dawn.lib_annotation.BindPath;

import androidx.appcompat.app.AppCompatActivity;
@BindPath(path="app/main2")
public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

    }
}