package com.jetpack.componentization.bean;

import android.view.View;
import android.widget.Button;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

import com.jetpack.baselib.util.LogUtil;
import com.jetpack.baselib.util.ToastUtil;

import java.io.IOException;

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
        testRxjava();
              getApiInterface()
                .checkAppResource("12234")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>(){

                    @Override
                    public void onSubscribe(Disposable d) {
                        netData.set("开始请求");
                        LogUtil.e("==http===开始请求");

                    }

                    @Override
                    public void onNext(ResponseBody o) {
                        try {
                            String str=o.string();
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
                        LogUtil.e("==http===请求onComplete===>");
                    }
                });
        ;
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



    public static <T> Observable<T> mainThread(Observable<T> o){
        return o.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        LogUtil.e("=life=onCleared===>");
    }
}
