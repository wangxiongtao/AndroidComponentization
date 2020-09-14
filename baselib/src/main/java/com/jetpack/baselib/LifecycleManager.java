package com.jetpack.baselib;


import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class LifecycleManager implements LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        LogUtil.e("===event==LifecycleActivity==life==onCreate==>");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        LogUtil.e("===event==LifecycleActivity==life==onStart==>");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        LogUtil.e("===event==LifecycleActivity==life==onResume==>");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        LogUtil.e("===event==LifecycleActivity==life==onPause==>");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        LogUtil.e("===event==LifecycleActivity==life==onStop==>");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        LogUtil.e("===event==LifecycleActivity==life==onDestroy==>");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    public void onAny() {
//        LogUtil.e("===event==LifecycleActivity==life==onAny==>");
    }
}
