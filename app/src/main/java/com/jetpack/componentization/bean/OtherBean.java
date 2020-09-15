package com.jetpack.componentization.bean;

import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.PropertyChangeRegistry;

import com.jetpack.componentization.BR;

public class OtherBean implements Observable {
    String string1;
    String string2;
    String string3;
    private transient PropertyChangeRegistry propertyChangeRegistry = new PropertyChangeRegistry();


    @Bindable
    public String getString1() {
        return string1;
    }

    public void setString1(String string1) {
        this.string1 = string1;
        notifyChange(BR.string1);
    }

    @Bindable
    public String getString2() {
        return string2;
    }

    public void setString2(String string2) {
        this.string2 = string2;
        notifyChange(BR.string2);
    }

    @Bindable
    public String getString3() {
        return string3;
    }

    public void setString3(String string3) {
        this.string3 = string3;
        notifyChange(BR.string3);
    }

    private synchronized void notifyChange(int propertyId) {
        if (propertyChangeRegistry == null) {
            propertyChangeRegistry = new PropertyChangeRegistry();
        }
        propertyChangeRegistry.notifyChange(this, propertyId);
    }

    @Override
    public synchronized void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        if (propertyChangeRegistry == null) {
            propertyChangeRegistry = new PropertyChangeRegistry();
        }
        propertyChangeRegistry.add(callback);

    }

    @Override
    public synchronized void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        if (propertyChangeRegistry != null) {
            propertyChangeRegistry.remove(callback);
        }
    }
}
