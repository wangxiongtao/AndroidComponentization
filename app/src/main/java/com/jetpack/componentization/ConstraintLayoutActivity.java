package com.jetpack.componentization;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.jetpack.baselib.util.LogUtil;
import com.jetpack.componentization.ui.view.FloatDragView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.reactivex.Observable;

public class ConstraintLayoutActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_layout);
        List<String>list=new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        Observable.fromIterable(list).subscribe();



        int[] arr ={1,2,3,4,5,6,7,8,9};
//                 [5, 1, 7, 8, 0, 2, 9, 5, 10]
//                 [1, 5, 7, 0, 2, 8, 5, 9, 10]


        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;

                }
            }
            LogUtil.e("==arr==>"+ Arrays.toString(arr));
        }

        Button button=findViewById(R.id.button2);
//        FloatDragView floatDragView=new FloatDragView();
////        floatDragView.setTargetView(button);









        LinearLayout ll1=findViewById(R.id.ll1);
        FloatDragView floatDragView2=new FloatDragView();
        floatDragView2.setTargetView(ll1);

        RecyclerView recyclerView=findViewById(R.id.rv);
        recyclerView.setAdapter(new MyAdapter());






    }




























































    class MyAdapter extends RecyclerView.Adapter<MyAdapter.Vh>{


        @NonNull
        @Override
        public Vh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            TextView textView=new TextView(parent.getContext());
            textView.setPadding(10,10,10,10);
            textView.setTextColor(Color.parseColor("#FF6600"));
            textView.setTextSize(32);
            return new Vh(textView);
        }

        @Override
        public void onBindViewHolder(@NonNull Vh holder, int position) {
            ((TextView)holder.itemView).setText("item=====>"+position);

        }

        @Override
        public int getItemCount() {
            return 100;
        }

        class Vh extends RecyclerView.ViewHolder{

            public Vh(@NonNull View itemView) {
                super(itemView);
            }
        }
    }
}