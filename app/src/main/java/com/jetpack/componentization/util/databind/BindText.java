package com.jetpack.componentization.util.databind;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import com.jetpack.baselib.LogUtil;

public class BindText {
    @BindingAdapter({"android:bindText"})
    public static void imageLoader(TextView textView, String text111) {
       textView.setText(text111);
        LogUtil.e("==bindText=imageLoader====>");
    }
    @BindingAdapter({"bindText"})
    public static void imageLoader(ImageView textView, String text) {

        LogUtil.e("==bindText=imageLoader1====>");
    }

}
