package com.jetpack.componentization.ui.rx;

public class ObservableMap extends AbsObservable {
    RXObservable observable;
    ChangeDataCallback changeDataCallback;

    public ObservableMap(RXObservable observable,ChangeDataCallback changeDataCallback) {
        this.observable = observable;
        this.changeDataCallback=changeDataCallback;
    }
    @Override
    public void addObserverTrue(RXObserver observer) {
        observable.addObserver(new MyMap(observer,changeDataCallback));

    }

    static class MyMap implements RXObserver {
        RXObserver observer;

        public MyMap(RXObserver observer, ChangeDataCallback changeDataCallback) {
            this.observer = observer;
            this.changeDataCallback = changeDataCallback;
        }

        ChangeDataCallback changeDataCallback;

        @Override
        public void onNext(String s) {
            s=changeDataCallback.changeData(s);
            observer.onNext(s);

        }
    }

}



