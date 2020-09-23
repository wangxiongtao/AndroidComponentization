package com.jetpack.lib_common.api;

import androidx.lifecycle.LiveData;

import com.jetpack.lib_common.http.HttpManager;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class ApiRepository {
    public static void checkAppResource(String time,Observer<ResponseBody> observer) {
        HttpManager.getInstance().getApiInterface().checkAppResource(time)
                .onTerminateDetach()
                .compose(new ObservableTransformer<ResponseBody, ResponseBody>() {

                    @Override
                    public ObservableSource<ResponseBody> apply(Observable<ResponseBody> upstream) {
                        return upstream.subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread());
                    }
                }).subscribe(observer);
    }
    public static LiveData<ResponseBody> checkAppResource1(String time) {
        return HttpManager.getInstance().getApiInterface().checkAppResource1(time);
    }
    public static Integer checkAppResource2(String time) {
        return HttpManager.getInstance().getApiInterface().checkAppResource2("123");
    }

}
