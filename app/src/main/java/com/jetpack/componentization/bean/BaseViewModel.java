package com.jetpack.componentization.bean;

import androidx.lifecycle.ViewModel;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class BaseViewModel extends ViewModel implements Observer {


    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(Object o) {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}
