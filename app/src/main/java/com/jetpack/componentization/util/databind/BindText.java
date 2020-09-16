package com.jetpack.componentization.util.databind;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;
import androidx.databinding.InverseBindingListener;

import com.jetpack.baselib.util.LogUtil;
import com.jetpack.componentization.customerview.DataBindEditText;

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
    @BindingAdapter({"dataContent"})
    public static void imageLoader(DataBindEditText textView, String text) {
        if(textView.getDataContent().equals(text)){
            return;
        }
        textView.setDataContent(text);

        LogUtil.e("==bindText=imageLoader1====>");
    }
    @InverseBindingAdapter(attribute = "dataContent",event = "dataContentAttrChanged")
    public static String getTextString(DataBindEditText view) {
        return view.getDataContent();
    }
    @BindingAdapter({"dataContentAttrChanged"})
    public static void setDataContentAttrChanged(DataBindEditText view,InverseBindingListener dataContentAttrChanged){
        view.getEd().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(dataContentAttrChanged!=null){
                    dataContentAttrChanged.onChange();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
    @BindingAdapter({"dataSizeB"})
    public static void set(DataBindEditText editText,int size){
        editText.getEd().setTextSize(size);
    }

}
