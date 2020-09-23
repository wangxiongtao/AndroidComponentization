package com.jetpack.lib_common.http.converter;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

/**
 * Created by dell on 2018/4/3.
 */

public class FastJsonRequestBodyConverter <T> implements Converter<T, RequestBody> {
    private static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");



    @Override
    public RequestBody convert(T value) throws IOException {
        return null;
    }
}