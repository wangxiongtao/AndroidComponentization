package com.jetpack.lib_common.http.converter;

import com.jetpack.baselib.util.LogUtil;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by dell on 2018/4/3.
 */

public class FastJsonConverterFactory extends Converter.Factory{

    public static FastJsonConverterFactory create() {
        return new FastJsonConverterFactory();
    }

    /**
     * 需要重写父类中responseBodyConverter，该方法用来转换服务器返回数据
     */
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        LogUtil.e("==Annotation===>"+annotations);
        return new FastJsonResponseBodyConverter<>(type);
    }
}