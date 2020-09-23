package com.jetpack.componentization;

import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

import com.jetpack.baselib.util.LogUtil;
import com.jetpack.baselib.base.RxLifeObserver;
import com.jetpack.componentization.databinding.ActivityRXTestBinding;
import com.jetpack.componentization.ui.rx.ChangeDataCallback;
import com.jetpack.componentization.ui.rx.MyObservable;
import com.jetpack.componentization.ui.rx.ObserverCallback;
import com.jetpack.componentization.ui.rx.RXObserver;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class RXTestActivity extends AppCompatActivity {
    ActivityRXTestBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityRXTestBinding.inflate(getLayoutInflater());
        fun();
        setContentView(binding.getRoot());
        getLifecycle().addObserver(new LifecycleEventObserver() {
            @Override
            public void onStateChanged(@NonNull LifecycleOwner source, @NonNull Lifecycle.Event event) {

            }
        });

        Observable.interval(1, TimeUnit.SECONDS).subscribe(new RxLifeObserver<Long>(this) {


            @Override
            public void onSubscribe() {

            }

            @Override
            public void onNext(Long aLong) {
                LogUtil.e("==interval1===>"+aLong);

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
        Observable.interval(2, TimeUnit.SECONDS).subscribe(new RxLifeObserver<Long>(this) {


            @Override
            public void onSubscribe() {

            }

            @Override
            public void onNext(Long aLong) {
                LogUtil.e("==interval2===>"+aLong);

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });










    }

    public void toFun(){
        new MyObservable(new ObserverCallback() {
            @Override
            public void callBack(RXObserver observer) {
                observer.onNext("111");
            }
        }).addObserver(new RXObserver() {
            @Override
            public void onNext(String s) {


            }
        });

    }













    public void fun(){
        new MyObservable(new ObserverCallback() {
            @Override
            public void callBack(RXObserver observer) {
                LogUtil.e("==thread=1==>"+Thread.currentThread().getName());
                observer.onNext("111");
            }
        }).mainHandler().map(new ChangeDataCallback() {
            @Override
            public String changeData(String s) {
                LogUtil.e("==thread=2==>"+Thread.currentThread().getName());
                return s+"vvvv";
            }
        }).map(new ChangeDataCallback() {
            @Override
            public String changeData(String s) {
                LogUtil.e("==thread=3==>"+Thread.currentThread().getName());
                return s+"bbbbbb";
            }
        }).newThread("thread--1")
                .newThread("thread--2")
                .addObserver(new RXObserver() {
                    @Override
                    public void onNext(String s) {
                        LogUtil.e("==thread=4==>"+Thread.currentThread().getName());
                        LogUtil.e("==next=thread==>"+s);
                        binding.rxTv.setText(s);
                    }
                });



        MyObservable myObservable =new MyObservable(new ObserverCallback() {
            @Override
            public void callBack(RXObserver observer) {
                LogUtil.e("==callBack=thread=1==>"+Thread.currentThread().getName());
            }
        });

        Handler handler=new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                new Thread("2222"){
                    @Override
                    public void run() {
                        super.run();
                        myObservable.addObserver(new RXObserver() {
                            @Override
                            public void onNext(String s) {

                            }
                        });

                    }
                }.start();
            }
        });





//        ObserverThread observerThread= (ObserverThread) myObservable.newThread("111");
//        observerThread.addObserver(new RXObserver() {
//            @Override
//            public void onNext(String s) {
//                LogUtil.e("==callBack=thread=onNext==>"+Thread.currentThread().getName());
//            }
//        });

    }







}