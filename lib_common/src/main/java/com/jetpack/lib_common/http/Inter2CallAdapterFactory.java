package com.jetpack.lib_common.http;

import androidx.annotation.Nullable;

import com.jetpack.baselib.util.LogUtil;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class Inter2CallAdapterFactory extends CallAdapter.Factory {

    @Override
    public CallAdapter<?, ?> get(@Nullable Type returnType, @Nullable Annotation[] annotations, @Nullable Retrofit retrofit) {
        if (getRawType(returnType) != Integer.class) {
            return null;
        }
//        Type responseType = getParameterUpperBound(0, (ParameterizedType) returnType);
        return new Inter2CallAdapter(returnType);
    }

    static class Inter2CallAdapter implements CallAdapter<java.lang.Integer, Object> {
        Type responseType;

        public Inter2CallAdapter(Type responseType) {
            this.responseType = responseType;
        }
        @Override
        public Type responseType() {

            return responseType;
        }

        @Override
        public Object adapt(Call<Integer> call) {
            final Integer[] integer = {1};
            integer[0] =234;
            call.enqueue(new Callback<Integer>() {
                @Override
                public void onResponse(Call<Integer> call, Response<Integer> response) {
                    integer[0] =response.body();
                    LogUtil.e("onResponse2===>"+integer[0]);
                }

                @Override
                public void onFailure(Call<Integer> call, Throwable t) {

                }
            });

//            try {
//                liveData.postValue(call.execute().body());
//            } catch (IOException e) {
//                liveData.postValue(null);
//            }

            return integer[0];
        }
    }
}




