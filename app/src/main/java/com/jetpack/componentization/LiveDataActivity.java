package com.jetpack.componentization;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.jetpack.baselib.util.LogUtil;

public class LiveDataActivity extends AppCompatActivity {
    MutableLiveData<MyData>liveData=new MutableLiveData<>();
    MyData myData=new MyData("11111");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data);
        liveData.observe(this, new Observer<MyData>() {
            @Override
            public void onChanged(MyData s) {
                LogUtil.e("---onChanged------>"+s);
            }
        });
    }

    public void onClickL(View view) {

        liveData.postValue(myData);
    }


    class MyData{
        public MyData(String string) {
            this.string = string;
        }

        public String string;
    }
}