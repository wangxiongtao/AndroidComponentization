package com.jetpack.componentization.customerview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;

import com.jetpack.componentization.R;
import com.jetpack.componentization.databinding.DataBindEdittextLayoutBinding;

public class DataBindEditText extends LinearLayout {
    DataBindEdittextLayoutBinding edittextLayoutBinding;
    private String dataContent;
    private int dataSize;
    public DataBindEditText(Context context) {
        super(context);
        init(null);
    }

    public DataBindEditText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public DataBindEditText(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }
    private void init(AttributeSet attributeSet){
         edittextLayoutBinding= DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.data_bind_edittext_layout, this, true);
        if(attributeSet!=null){
            TypedArray typedArray = getContext().obtainStyledAttributes(attributeSet, R.styleable.DataBindEditText);
            dataContent= typedArray.getString(R.styleable.DataBindEditText_dataContent);
            dataSize= typedArray.getInteger(R.styleable.DataBindEditText_dataSizeB,10);
            edittextLayoutBinding.editQuery.setText(dataContent);
            edittextLayoutBinding.editQuery.setTextSize(dataSize);
            typedArray.recycle(); // 因为源码中是进行回收的
        }

    }
    public void setDataContent(String content){
        this.dataContent=content;
        edittextLayoutBinding.editQuery.setText(content);
    }

    public String getDataContent() {
        return edittextLayoutBinding.editQuery.getText().toString();
    }
    public EditText getEd(){
        return edittextLayoutBinding.editQuery;
    }
}
