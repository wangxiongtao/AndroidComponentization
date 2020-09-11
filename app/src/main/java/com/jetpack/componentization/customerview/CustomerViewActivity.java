package com.jetpack.componentization.customerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.jetpack.componentization.R;

public class CustomerViewActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_view);
        textView=findViewById(R.id.infoTv);
        String string1="setContentView->" +
                "Window.setContentView->" +
                "PhoneWindow.setContentView->" +
                "initDecorView(FrameLayout)->id=" +
                "content";
        String string2="ViewRootImpl中的performTraversals方法中通过获取当前子view的测量模式，" +
                "然后一层一层的传下去；" +
                "再ViewGroup中又根据与子类的尺寸与自身的尺寸大小得出子类的测量spec,回调到子类的onMeasure方法中";
        textView.setText(string1+"\n\n"+string2);
    }

    public void onClick(View view) {
        Intent intent=new Intent(view.getContext(),XfermodeViewActivity.class);
        startActivity(intent);
    }
}