package com.jetpack.componentization.bean;

import android.view.View;
import android.widget.Button;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

import com.jetpack.baselib.base.BaseViewModel;
import com.jetpack.baselib.base.RxLifeObserver;
import com.jetpack.baselib.util.LogUtil;
import com.jetpack.baselib.util.ToastUtil;
import com.jetpack.lib_common.api.ApiRepository;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.internal.operators.observable.ObservableCreate;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class UserViewModel extends BaseViewModel {
    public ObservableField<String> modelName=new ObservableField<>();
    public ObservableField<String> bindText=new ObservableField<>();
    public ObservableField<OrderBean>orderBean=new ObservableField<>();
    public ObservableField<String>editTextString=new ObservableField<>();
    public ObservableField<String>dataContent=new ObservableField<>();
    public ObservableField<String>netData=new ObservableField<>("点击请求");
    public ObservableInt dataSize=new ObservableInt();


    public void click(View view, int dddd){
        Button v= (Button) view;
        ToastUtil.toast("点击了=view===>"+v.getText().toString()+"----"+dddd);
        checkResource();


    }
    public void click1(){
        ToastUtil.toast("点击了==111=>"+bindText.get());

    }


    public void checkResource(){
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



        ApiRepository.checkAppResource("11", new RxLifeObserver<ResponseBody>(this) {


            @Override
            public void onSubscribe() {
                netData.set("开始请求223344");
                LogUtil.e("==http===开始请求");
            }

            @Override
            public void onNext(ResponseBody responseBody) {
                LogUtil.e("==thread==onNext==>"+Thread.currentThread().getName());
                try {
                    String str=responseBody.string();
                    LogUtil.e("==http===请求成功o===>"+str);
                    netData.set(str);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onError(Throwable e) {
                LogUtil.e("==http===请求失败o===>"+e.getLocalizedMessage());
            }

            @Override
            public void onComplete() {

            }
        });


        testRxjava();

    }


    public void testRxjava(){
        new ObservableCreate<String>(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                LogUtil.e("==thread==1==>"+Thread.currentThread().getName());
                Thread.sleep(8000);
                emitter.onNext("11111");

            }
        }).observeOn(AndroidSchedulers.mainThread()).map(new Function<String, String>() {

            @Override
            public String apply(String s) throws Exception {
                LogUtil.e("==thread==2==>"+Thread.currentThread().getName());
                return "111";
            }
        }).subscribeOn(Schedulers.io())
                .subscribeOn(Schedulers.io())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                LogUtil.e("==thread==3==>"+Thread.currentThread().getName());
            }

            @Override
            public void onNext(String s) {
                LogUtil.e("==thread==4==>"+Thread.currentThread().getName());
//                ToastUtil.toast(s);

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

}
