package com.jetpack.componentization.bean;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;

import com.jetpack.componentization.BR;

public class UserBean extends BaseObservable {

    @Bindable
    public String name;

    public ObservableField<String> name2 = new ObservableField<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

}
