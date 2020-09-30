package com.jetpack.componentization.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.jetpack.baselib.util.LogUtil;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class MyAudioBeatView extends View {
    RectF rectF1;
    RectF rectF2;
    RectF rectF3;
    RectF rectF4;
    RectF rectF5;
    Paint paint;
    int itemW=15;
    private Disposable disposable;
    public MyAudioBeatView(Context context) {
        this(context,null);
    }

    public MyAudioBeatView(Context context, @Nullable AttributeSet attrs) {
        this(context, null,0);
    }

    public MyAudioBeatView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        rectF1=new RectF(0,0,itemW,0);
        rectF2=new RectF(0,0,itemW,0);
        rectF3=new RectF(0,0,itemW,0);
        rectF4=new RectF(0,0,itemW,0);
        rectF5=new RectF(0,0,itemW,0);

        paint=new Paint();
        paint.setColor(Color.parseColor("#FF6600"));
        disposable= Observable.interval(120, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread())
                .subscribe((a)-> {
                    LogUtil.e("==long====>"+a);
                    rectF1.bottom=getRandom(getHeight(),0);
                    rectF2.bottom=getRandom(getHeight(),0);
                    rectF3.bottom=getRandom(getHeight(),0);
                    rectF4.bottom=getRandom(getHeight(),0);
                    rectF5.bottom=getRandom(getHeight(),0);
                    invalidate();
                });

    }
    int getRandom(int max,int min){
        return (int) (Math.random()*(max-min)+min);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        rectF1.top=getHeight();
        rectF2.top=getHeight();
        rectF3.top=getHeight();
        rectF4.top=getHeight();
        rectF5.top=getHeight();

        canvas.translate(itemW,0);

        canvas.drawRect(rectF1,paint);

        canvas.translate(itemW*2,0);

        canvas.drawRect(rectF2,paint);

        canvas.translate(itemW*2,0);

        canvas.drawRect(rectF3,paint);
        canvas.translate(itemW*2,0);

        canvas.drawRect(rectF4,paint);
        canvas.translate(itemW*2,0);

        canvas.drawRect(rectF5,paint);



    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        disposable.dispose();
    }
}
