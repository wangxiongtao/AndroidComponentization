package com.jetpack.componentization.ui.main;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    MutableLiveData<String>userLiveData=new MutableLiveData<>();
    public void setUserLiveData(String user){
        userLiveData.postValue(user);
    }

    public MutableLiveData<String> getUserLiveData() {
        return userLiveData;
    }
    public void observe(@NonNull LifecycleOwner owner, @NonNull Observer<String> observer) {
         userLiveData.observe(owner,observer);
    }
}