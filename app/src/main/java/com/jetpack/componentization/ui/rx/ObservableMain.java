package com.jetpack.componentization.ui.rx;


import android.os.Handler;
import android.os.Looper;

public class ObservableMain extends AbsObservable {
    RXObservable observable;

    public ObservableMain(RXObservable observable) {
        this.observable = observable;
    }

    @Override
    public void addObserverTrue(RXObserver observer) {
        Handler handler=new Handler(Looper.getMainLooper());
        observable.addObserver(new RXObserver() {
            @Override
            public void onNext(String s) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        observer.onNext(s);
                    }
                });
            }
        });

    }
}
