package com.jetpack.componentization.jetpack;


import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import com.jetpack.baselib.LogUtil;

public class JetPackManager implements LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        LogUtil.e("===OnLifecycleEvent==onCreate==>");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        LogUtil.e("===OnLifecycleEvent==onStart==>");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        LogUtil.e("===OnLifecycleEvent==onResume==>");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        LogUtil.e("===OnLifecycleEvent==onPause==>");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        LogUtil.e("===OnLifecycleEvent==onStop==>");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        LogUtil.e("===OnLifecycleEvent==onDestroy==>");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    public void onAny() {
        LogUtil.e("===OnLifecycleEvent==onAny==>");
    }
}
