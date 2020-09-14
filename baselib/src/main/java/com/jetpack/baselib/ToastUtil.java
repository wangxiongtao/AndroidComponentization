package com.jetpack.baselib;
import android.content.Context;
import android.widget.Toast;

import com.jetpack.baselib.base.BaseApplication;

public class ToastUtil {
     public static void toast(String msg){
         Toast.makeText(BaseApplication.getApplication(),msg,Toast.LENGTH_SHORT).show();
    }
}
