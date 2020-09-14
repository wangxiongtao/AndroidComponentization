package com.jetpack.componentization.util.databind;

import android.widget.TextView;

import androidx.databinding.BindingAdapter;

public class BindText {
    @BindingAdapter({"bind:bindText"})
    public static void imageLoader(TextView textView, String text) {
       textView.setText(text);
    }
}
