package com.jetpack.componentization.ui.rx;

import com.jetpack.baselib.util.LogUtil;

public class ObserverThread extends AbsObservable {
    RXObservable observable;
    String threadName;

    public ObserverThread(RXObservable observable,String threadName) {
        this.observable = observable;
        this.threadName=threadName;
    }

    @Override
    public void addObserverTrue(RXObserver observer) {
        Thread thread=new Thread(threadName){
            @Override
            public void run() {
                super.run();
                LogUtil.e("addObserverTrue==Thread====>"+Thread.currentThread().getName());
                observable.addObserver(observer);
            }
        };
        thread.start();
    }
}
