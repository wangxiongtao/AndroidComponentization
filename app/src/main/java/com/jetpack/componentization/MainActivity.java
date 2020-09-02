package com.jetpack.componentization;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
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


    }
}