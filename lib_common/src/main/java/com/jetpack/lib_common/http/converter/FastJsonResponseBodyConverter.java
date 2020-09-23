package com.jetpack.lib_common.http.converter;

import androidx.annotation.Nullable;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by dell on 2018/4/3.
 */

public class FastJsonResponseBodyConverter <T> implements Converter<ResponseBody, Integer> {
    private final Type type;

    public FastJsonResponseBodyConverter(Type type) {
        this.type = type;
    }

    @Nullable
    @Override
    public Integer convert(ResponseBody value) throws IOException {
        Reader reader=value.charStream();
        return 52159523;
    }

    /*
    * 转换方法
    */

}