package com.jetpack.componentization.ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    MutableLiveData<String>userLiveData=new MutableLiveData<>();
    public void setUserLiveData(String user){
        userLiveData.postValue(user);
    }

    public MutableLiveData<String> getUserLiveData() {
        return userLiveData;
    }
}