package com.jetpack.componentization.ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class RoundImageView extends androidx.appcompat.widget.AppCompatImageView {
    private BitmapShader mBitmapShader;
    private Paint mPaintCircle;

    public RoundImageView(@NonNull Context context) {
        super(context);
//        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
    }

    public RoundImageView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
//        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
    }

    public RoundImageView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
//        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
    }
























    //    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.GRAY);
//        super.onDraw(canvas);
//        Drawable drawable=getDrawable();
//        Paint paint=new Paint();
//
////
//        int layerId = canvas.saveLayer(0, 0, getWidth(), getHeight(), paint, Canvas.ALL_SAVE_FLAG);
//        canvas.drawBitmap(getSrcBitmap(),0,0,paint);
//        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
//        canvas.drawBitmap(getShapeBitmap(),0,0,paint);
//        canvas.restoreToCount(layerId);
//        Bitmap bitmap=Bitmap.createBitmap(getWidth(),getHeight(), Bitmap.Config.ARGB_8888);
//        Canvas myCanvas=new Canvas(bitmap);
//        super.onDraw(myCanvas);
//
//
//
//
//        Paint paint=new Paint();
//
//
//
//
//        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
//
//
//        Bitmap bitmap1=Bitmap.createBitmap(getWidth(),getHeight(), Bitmap.Config.ARGB_8888);
//        Canvas canvas1=new Canvas(bitmap1);
//        canvas1.drawCircle(getWidth()/2, getHeight()/2, getWidth()/2, paint);
////
//
//        paint.setXfermode(new PorterDuffXfermode(
//                PorterDuff.Mode.DST_IN));
//        myCanvas.drawBitmap(bitmap1,0,0,paint);








        //获得图片的宽度
//        int width=getWidth();
//        //获得图片的高度
//        int height=getHeight();
//        //短的二分之一作为半径
//        int radius=height>width?width/2:height/2;
//
//        //重新定义的一个画布，这一步很关键
//        Paint mPaint = new Paint();
//        //抗锯齿
//        mPaint.setAntiAlias(true);
//        Bitmap bitmap = Bitmap.createBitmap(width,height,
//                Bitmap.Config.ARGB_8888);
//        Canvas bitmapCanvas = new Canvas(bitmap);
//        super.onDraw(bitmapCanvas);
//
//        canvas.drawBitmap(bitmap, 0.0f, 0.0f, mPaint);
//
//
//
//
//
//
//
//        //圆形的框
//        Bitmap cB = Bitmap.createBitmap(width, height,
//                Bitmap.Config.ARGB_8888);
//        Canvas cCanv = new Canvas(cB);
//        //在控件中间画一个
//        cCanv.drawCircle(width/ 2, height/ 2, radius,
//                mPaint);
//
//
//        //dst是后画的图形
//        mPaint.setXfermode(new PorterDuffXfermode(
//                PorterDuff.Mode.DST_IN));
//
//
//
//        //一定要用之前的画布，不然会出现边角是黑色
//        bitmapCanvas.drawBitmap(cB, 0.0f, 0.0f, mPaint);

        //给图形加边框
//        Paint paint =new Paint();
//        paint.setAntiAlias(true);
//        paint.setStyle(Paint.Style.STROKE);
//        paint.setStrokeWidth(5);
//        paint.setColor(Color.BLACK);
//        canvas.drawCircle(width/ 2, height/ 2, radius,
//                paint);
        setBitmapShader();
        canvas.drawCircle(100, 0, getWidth()/2, mPaintCircle);










    }
    //src
    Bitmap getSrcBitmap(){
      Bitmap  bitmap=Bitmap.createBitmap(getWidth(),getHeight(), Bitmap.Config.ARGB_8888);
      Canvas canvas=new Canvas(bitmap);
      Drawable drawable=getDrawable();
      drawable.draw(canvas);
      return  bitmap;

    }
    Bitmap getShapeBitmap(){
      Bitmap  bitmap=Bitmap.createBitmap(getWidth(),getHeight(), Bitmap.Config.ARGB_8888);
      Canvas canvas=new Canvas(bitmap);
      Paint paint=new Paint();
      paint.setColor(Color.BLUE);
      canvas.drawCircle(getWidth()/2,getWidth()/2,getWidth()/2,paint);
      return  bitmap;

    }


























    //使用BitmapShader画圆图形
    private void setBitmapShader() {
        //将图片转换成Bitmap
        Drawable drawable = getDrawable();
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        Bitmap bitmap = bitmapDrawable.getBitmap();
        //将bitmap放进图像着色器，后面两个模式是x，y轴的缩放模式，CLAMP表示拉伸
        mBitmapShader = new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        //初始化图片与view之间伸缩比例，因为比例一般非整数，所以用float，免得精度丢失
        float scale = 1.0f;
//        float scaleX = 1.0f;
        //将图片的宽度高度的最小者作为图片的边长，用来和view来计算伸缩比例
//        int bitmapSize = Math.min(bitmap.getWidth(), bitmap.getHeight());
        int bitmapSize = Math.min(bitmap.getHeight(), bitmap.getWidth());


        //        int bitmapSizeX = bitmap.getWidth();
        //      scaleX = mWidth * 1.0f / bitmapSizeX;
        /**注意这里，我使用的是图片最长的（就是宽度）来伸缩，那么用这个的话，
         * 我们就会发现，较短的那边（就是高度）在经过Matrix的拉伸后会发现失真，强行地被拉长，
         * 一、因为图片为了适应最长的那边可以完全在view上展示，把长的给压缩了，而短的比长的那边短，所以要强行拉伸，那么就会导致短的这边被拉伸时候失真
         *二、因为图像的变换是针对每一个像素点的，所以有些变换可能发生像素点的丢失，
         * 这里需要使用Paint.setAnitiAlias(boolean)设置来消除锯齿，这样图片变换后的效果会好很多。

         */

        //计算缩放比例，view的大小和图片的大小比例
        scale = getWidth() * 1.0f / bitmapSize;
        //利用这个图像变换处理器，设置伸缩比例，长宽以相同比例伸缩
        Matrix mMatrix=new Matrix();
        mMatrix.setScale(scale, scale);
        //给那个图像着色器设置变换矩阵，绘制时就根据view的size，设置图片的size
        //使图片的较小的一边缩放到view的大小一致，这样就可以避免图片过小导致CLAMP拉伸模式或过大导致显示不全
        mBitmapShader.setLocalMatrix(mMatrix);
        //为画笔套上一个Shader的笔套
        mPaintCircle=new Paint();
        mPaintCircle.setShader(mBitmapShader);
    }






}
