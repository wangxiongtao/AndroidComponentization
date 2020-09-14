package com.jetpack.baselib.base;

import android.app.Application;

import com.jetpack.baselib.router.AppRouter;

public class BaseApplication extends Application {
    private static BaseApplication application;
    @Override
    public void onCreate() {
        super.onCreate();
        application=this;
        AppRouter.getInstance().init(this);
    }

    public static BaseApplication getApplication() {
        return application;
    }
}
