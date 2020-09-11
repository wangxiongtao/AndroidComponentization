package com.jetpack.componentization;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyView extends View {
    public MyView(@NonNull Context context) {
        super(context);
    }

    public MyView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()){
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
        return super.dispatchTouchEvent(event);
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
        return false;
    }
    private static  void logEvent(String name,String evNAme){
        Log.e("touch","=MyView="+name+"===="+evNAme);
    }
}
