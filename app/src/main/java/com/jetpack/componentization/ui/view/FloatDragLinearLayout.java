package com.jetpack.componentization.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.jetpack.baselib.util.LogUtil;

public class FloatDragLinearLayout extends LinearLayout {
    private int downX;
    private int downY;
    private int totalY;
    public FloatDragLinearLayout(Context context) {
        super(context);

    }

    public FloatDragLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

    }

    public FloatDragLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

//
//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent event) {
//
//
//        return true;
//
//
//
//    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                downX=x;
                downY=y;
                break;
            case MotionEvent.ACTION_MOVE:
                int offsetX = x - downX;
                int offsetY = y - downY;

//                offsetTopAndBottom(offsetY);
                totalY+=offsetY;
                LogUtil.e("==offsetY====>"+totalY);
//                targetView.offsetLeftAndRight(offsetX);

                break;
            case MotionEvent.ACTION_UP:
                LogUtil.e("up==offsetY====>"+y);
                LogUtil.e("up==offsetY==getHeight==>"+getHeight());
                break;
        }
        return super.dispatchTouchEvent(event);
    }
}
