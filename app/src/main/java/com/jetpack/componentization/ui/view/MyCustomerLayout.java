package com.jetpack.componentization.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.jetpack.baselib.util.LogUtil;

public class MyCustomerLayout extends ViewGroup {
    public MyCustomerLayout(Context context) {
        super(context);
    }

    public MyCustomerLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyCustomerLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }



    /**
     * 测量
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        final int count = getChildCount();
        // 临时ViewGroup大小值
        int viewGroupWidth = 0;
        int viewGroupHeight = 0;
        if (count > 0) {
            // 遍历childView
            for (int i = 0; i < count; i++) {
                // childView
                View child = getChildAt(i);
                MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
                //测量childView包含外边距
                measureChildWithMargins(child, widthMeasureSpec, 0, heightMeasureSpec, 0);
                // 计算父容器的期望值
                viewGroupWidth += child.getMeasuredWidth() + lp.leftMargin + lp.rightMargin;
                viewGroupHeight += child.getMeasuredHeight() + lp.topMargin + lp.bottomMargin;
            }

            // ViewGroup内边距
            viewGroupWidth += getPaddingLeft() + getPaddingRight();
            viewGroupHeight += getPaddingTop() + getPaddingBottom();

            //和建议最小值进行比较
            viewGroupWidth = Math.max(viewGroupWidth, getSuggestedMinimumWidth());
            viewGroupHeight = Math.max(viewGroupHeight, getSuggestedMinimumHeight());
        }
        setMeasuredDimension(resolveSize(viewGroupWidth, widthMeasureSpec), resolveSize(viewGroupHeight, heightMeasureSpec));
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

//        LogUtil.e("onLayout==l=>"+l);
//        LogUtil.e("onLayout==t=>"+t);
//        LogUtil.e("onLayout==r=>"+r);
//        LogUtil.e("onLayout==b=>"+b);
        layoutChild(0,0);



    }
    int childL=0;
    int childT=0;
    int childR=0;
    int childB=0;
    public void layoutChild(int count,int childL){
        LogUtil.e("layoutChild==count=>"+count);
        LogUtil.e("layoutChild==childL=>"+childL);

//        if(count<getChildCount()){
//            View view=getChildAt(count);
//            int childR=view.getMeasuredWidth()+childL;
//            LogUtil.e("layoutChild==childR=>"+childR);
//            if(childR>getMeasuredWidth()){
//                LogUtil.e("layoutChild==换行");
//                childL=0;
//                childT=view.getMeasuredHeight()+30;
//            }
//            view.layout(childL,childT,childR,view.getMeasuredHeight()+childT);
//            childL=childL+view.getMeasuredWidth();
//            count++;
//            layoutChild(count,childL);
//
//        }

        for (int i=0;i<getChildCount();i++){
            View view=getChildAt(i);
            MarginLayoutParams layoutParams = (MarginLayoutParams) view.getLayoutParams();
            LogUtil.e("layoutChild==layoutParams===leftMargin=>"+layoutParams.leftMargin);
            LogUtil.e("layoutChild==layoutParams===width=>"+layoutParams.width);
            childL=childL+layoutParams.leftMargin;
            childR=view.getMeasuredWidth()+childL;

            if(childR>getMeasuredWidth()){
                LogUtil.e("layoutChild==换行");
                childL=0;
                childT+=view.getMeasuredHeight();
            }

            view.layout(childL,childT,childR,view.getMeasuredHeight()+childT);
            childL=childL+view.getMeasuredWidth();

        }
    }

    @Override
    protected LayoutParams generateLayoutParams(LayoutParams p) {
        return new MarginLayoutParams(p);
    }
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }

    @Override
    protected boolean checkLayoutParams(LayoutParams p) {
        return p instanceof MarginLayoutParams;
    }
}
