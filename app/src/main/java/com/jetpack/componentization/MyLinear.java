package com.jetpack.componentization;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class MyLinear extends LinearLayout {
    public MyLinear(Context context) {
        super(context);
    }

    public MyLinear(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyLinear(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

//    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                logEvent("dispatchTouchEvent","ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                logEvent("dispatchTouchEvent","ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                logEvent("dispatchTouchEvent","ACTION_UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                logEvent("dispatchTouchEvent","ACTION_CANCEL");
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

//    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
         switch (ev.getAction()){
             case MotionEvent.ACTION_DOWN:
                 logEvent("onInterceptTouchEvent","ACTION_DOWN");
                 break;
             case MotionEvent.ACTION_MOVE:
                 logEvent("onInterceptTouchEvent","ACTION_MOVE");
                 break;
             case MotionEvent.ACTION_UP:
                 logEvent("onInterceptTouchEvent","ACTION_UP");
                 break;
             case MotionEvent.ACTION_CANCEL:
                 logEvent("onInterceptTouchEvent","ACTION_CANCEL");
                 break;
         }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                logEvent("onTouchEvent","ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                logEvent("onTouchEvent","ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                logEvent("onTouchEvent","ACTION_UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                logEvent("onTouchEvent","ACTION_CANCEL");
                break;
        }
        return true;
    }


    private static  void logEvent(String name,String evNAme){
        Log.e("touch","=myLinear="+name+"===="+evNAme);
    }


}
