package com.jetpack.componentization.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.jetpack.baselib.LogUtil;
import com.jetpack.componentization.R;

public class XfermodeView extends View {
    Paint paint;
    Bitmap bitmap;
    Canvas mC;
    private Bitmap bitmapD;

    public XfermodeView(Context context) {
        super(context);
        init();
    }

    public XfermodeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public XfermodeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    private void init(){
        paint=new Paint();
        bitmap= BitmapFactory.decodeResource(getResources(), R.mipmap.img_h3c_banner);
        LogUtil.e("bitmap====getWidth=>"+bitmap.getWidth());
        LogUtil.e("bitmap===getHeight=>"+bitmap.getHeight());
//        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
         bitmapD=makeDst(300,300);


    }
    private void drawPath() {
        Path path=new Path();
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(30);
        paint.setStyle(Paint.Style.STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
        path.moveTo(100, 100);
        path.lineTo(200,200);
        mC.drawPath(path, paint);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap,0,0,null);
        canvas.drawBitmap(bitmapD,0,0,null);
        drawPath();
//        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));

//        Bitmap bitmap2=makeSrc(300,300);
//        canvas.drawBitmap(bitmap2,0,0,paint);

//        Bitmap bitmap1=makeDst1();
//        paint.setXfermode(null);
//        canvas.drawBitmap(bitmap1,0,400,paint);
//        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
//        canvas.drawBitmap(bitmap,0,400,paint);













//
//

//        paint.setColorFilter(new LightingColorFilter(Color.WHITE,Color.parseColor("#FF6600")));
//        canvas.drawBitmap(bitmap,0,0,paint);
//
//        paint.setColorFilter(new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.DARKEN));
//        canvas.drawBitmap(bitmap,0,bitmap.getHeight(),paint);
//
//
//        paint.setColorFilter(new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.CLEAR));
//
//        RectF rectF=new RectF(0,bitmap.getHeight(),bitmap.getWidth(),bitmap.getHeight()*2);
//        paint.setColor(Color.YELLOW);
//        canvas.drawRect(rectF,paint);

//        Path path=new Path();
//        path.moveTo(0,bitmap.getHeight());
//        path.lineTo(200,300+bitmap.getHeight());
//        canvas.drawPath(path,paint);



//        paint.setColorFilter(null);
//        canvas.drawBitmap(bitmap,0,bitmap.getHeight()*2,paint);
//
//
//
//
//        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
//        RectF rectF=new RectF(200,bitmap.getHeight()*2,bitmap.getWidth()+200,bitmap.getHeight()*3);
//        paint.setColor(Color.BLUE);
//        canvas.drawRect(rectF,paint);

    }
    // create a bitmap with a circle, used for the "dst" image
     Bitmap makeDst(int w, int h) {
        Bitmap bm = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        mC = new Canvas(bm);
//         paint.setColor(0xFFFFCC44);
//         mC.drawOval(new RectF(0, 0, w*3/4, h*3/4), paint);
         mC.drawColor(0xFFFFCC44);
        return bm;
    }

    // create a bitmap with a rect, used for the "src" image
     Bitmap makeSrc(int w, int h) {
        Bitmap bm = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
//        Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);

//         paint.setColor(0xFF66AAFF);
//         mC.drawRect(w/3, h/3, w*19/20, h*19/20, paint);
        return bm;
    }
     Bitmap makeDst1() {
        Bitmap bm = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bm);
        Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
         p.setColor(0xFFFFCC44);
        c.drawCircle(bitmap.getWidth()/2,bitmap.getHeight()/2,bitmap.getHeight()/2,p);

//        p.setColor(0xFFFFCC44);
//        c.drawOval(new RectF(0, 0, w*3/4, h*3/4), p);
        return bm;
    }

    // create a bitmap with a rect, used for the "src" image
//    static Bitmap makeSrc1(int w, int h) {
//        Bitmap bm = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
//        Canvas c = new Canvas(bm);
//        Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
//
//        c.drawBitmap(bm,0,0,p);
//        return bm;
//    }
}
