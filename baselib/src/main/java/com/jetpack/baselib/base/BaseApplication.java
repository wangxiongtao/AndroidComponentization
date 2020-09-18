package com.jetpack.baselib.base;

import android.app.Application;

import com.jetpack.baselib.util.LogUtil;

public class BaseApplication extends Application {
    private static BaseApplication application;
    @Override
    public void onCreate() {
        super.onCreate();
        application=this;
        LogUtil.e("==init==Application=onCreate====>");
    }

    public static BaseApplication getApplication() {
        return application;
    }
}
