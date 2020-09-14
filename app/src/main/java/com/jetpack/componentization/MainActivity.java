package com.jetpack.componentization;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.jetpack.componentization.customerview.CustomerViewActivity;
import com.jetpack.componentization.jetpack.JetPackActivity;
import com.jetpack.componentization.ui.main.MainViewModel;
import com.jetpack.home.life.LifecycleActivity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    MainViewModel mainViewModel;
    LinearLayout showll;
    List<TextView> textViewList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showll=findViewById(R.id.show_Ll);
        textViewList=new ArrayList<>();
        initList();
        addTextView();



    }

    void initList(){
        TextView textView=getTextView("触摸机制",TouchStudyActivity.class);
        textViewList.add(textView);
        TextView textView2=getTextView("自定义view", CustomerViewActivity.class);
        textViewList.add(textView2);
        TextView textView3=getTextView("生命周期", LifecycleActivity.class);
        textViewList.add(textView3);
        TextView textView4=getTextView("JetPack", JetPackActivity.class);
        textViewList.add(textView4);
    }
    TextView getTextView(String text, final Class<?> cls ){
        TextView textView=new TextView(this);
        textView.setText(text);
        textView.setPadding(10,30,10,30);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),cls);
                startActivity(intent);
            }
        });
        return  textView;
    }


    private void addTextView(){
        Iterator<TextView> iterator=textViewList.iterator();
        while (iterator.hasNext()){
            TextView textView=iterator.next();
            showll.addView(textView);
        }

    }


}
