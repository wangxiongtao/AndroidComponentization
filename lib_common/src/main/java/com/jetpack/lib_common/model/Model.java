package com.jetpack.lib_common.model;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class Model {
    public static <T> Observable<T> get(Observable<T> o) {
        return mainThread(o)
                .map(new Function<T, T>() {
                    @Override
                    public T apply(T o) throws Exception {
//                        if (!o.isCorrect()) {
//                            throw new APIException(o.getCode(),o.getMessage());
//                        }
//                        if(o.ext_body!=null){
//                            if(listener!=null){
//                                listener.onExtBody(o.ext_body);
//                            }
//                        }
//                        if (o.body == null) {
//                            return (T) "";
//                        }
//                        return o.body;
                        return  o;
                    }
                }).onErrorResumeNext(new Function<Throwable, Observable<T>>() {
                    @Override
                    public Observable<T> apply(Throwable e) throws Exception {
//                        LogUtils.MyLogE("===请求异常原始错误信息==>" + e.getMessage());
                        return Observable.error(HandlerException.handlerException(e));
                    }
                });
    }
    public static <T>Observable<T> mainThread(Observable<T> o){
        return o.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


}
