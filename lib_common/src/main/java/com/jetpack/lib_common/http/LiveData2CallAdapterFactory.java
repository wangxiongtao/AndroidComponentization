package com.jetpack.lib_common.http;

import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class LiveData2CallAdapterFactory extends CallAdapter.Factory {

    @Override
    public CallAdapter<?, ?> get(@Nullable Type returnType, @Nullable Annotation[] annotations, @Nullable Retrofit retrofit) {
        if (getRawType(returnType) != MutableLiveData.class) {
            return null;
        }
        Type responseType = getParameterUpperBound(0, (ParameterizedType) returnType);
        return new LiveDataAdapter<>(responseType);
    }

    static class LiveDataAdapter<R> implements CallAdapter<R, Object> {
        Type responseType;

        public LiveDataAdapter(Type responseType) {
            this.responseType = responseType;
        }
        @Override
        public Type responseType() {

            return responseType;
        }

        @Override
        public Object adapt(Call<R> call) {
            final MutableLiveData<R> liveData=new MutableLiveData<>();
            call.enqueue(new Callback<R>() {
                @Override
                public void onResponse(Call<R> call, Response<R> response) {
                    liveData.postValue(response.body());
                }

                @Override
                public void onFailure(Call<R> call, Throwable t) {
                    liveData.postValue(null);
                }
            });

//            try {
//                liveData.postValue(call.execute().body());
//            } catch (IOException e) {
//                liveData.postValue(null);
//            }

            return  liveData;
        }
    }
}




