package com.jetpack.baselib;

import android.app.Application;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class BaseApplication extends Application {
    static  BaseApplication application;
    @Override
    public void onCreate() {
        super.onCreate();
        application=this;
    }

    public static BaseApplication getApplication() {
        return application;
    }
}
