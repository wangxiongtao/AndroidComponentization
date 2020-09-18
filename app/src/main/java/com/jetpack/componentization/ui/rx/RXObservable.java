package com.jetpack.componentization.ui.rx;

/**
 * 被观察者接口
 */
public interface RXObservable {
    public void addObserver(RXObserver observer);
}
