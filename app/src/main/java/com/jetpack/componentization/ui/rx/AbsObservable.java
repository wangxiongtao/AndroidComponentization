package com.jetpack.componentization.ui.rx;

/**
 * 观察者的抽象类
 */
public abstract  class AbsObservable implements RXObservable {
    @Override
    public void addObserver(RXObserver observer) {
        addObserverTrue(observer);
    }

    public abstract void addObserverTrue(RXObserver observer);

    public AbsObservable map(ChangeDataCallback changeDataCallback){
        return new ObservableMap(this,changeDataCallback);
    }
    public AbsObservable newThread(String threadName){
        return new ObserverThread(this,threadName);
    }
    public AbsObservable mainHandler(){
        return new ObservableMain(this);
    }
}
