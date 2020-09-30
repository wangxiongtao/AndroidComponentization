package com.jetpack.componentization;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.jetpack.baselib.util.LogUtil;

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





    }
}