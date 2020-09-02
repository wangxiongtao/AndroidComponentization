package com.jetpack.componentization;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.jetpack.componentization.ui.main.MainFragment;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

    }
}