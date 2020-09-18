package com.jetpack.componentization.ui.rx;


/**
 * 被观察者
 */
public class MyObservable extends AbsObservable {
    ObserverCallback callback;

    public MyObservable(ObserverCallback callback) {
        this.callback = callback;
    }



    /**
     * 添加注册观察者 来处理我的数据
     * @param observer
     */
    @Override
    public void addObserverTrue(RXObserver observer) {
//        String data="1111";// 我生成一个数据 给observer处理
//       observer.onNext(data);//
        callback.callBack(observer);//回传出去，让调用者处理

    }


}
