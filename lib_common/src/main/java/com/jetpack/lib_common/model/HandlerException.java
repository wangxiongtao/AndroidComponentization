package com.jetpack.lib_common.model;

public class HandlerException {
    public static final String LOGIN_INVALID_EXCEPTION = "请重新登录";
    public static final String SERVER_EXCEPTION = "服务器开小差啦，请稍后再试";
    public static final String TIME_OUT_EXCEPTION = "网络请求超时，请稍后再试";
    public static final String NETWORK_EXCEPTION = "网络开小差啦，请稍后再试";
    public static final String JSON_EXCEPTION = "数据类型转换错误";

    public static final int LOGIN_INVALID_CODE = 401;
    public static final int NETWORK_CODE = -900010;
    public static final int JSON_CODE = -900011;
    public static final int OTHER_CODE = -9000101;

    public static Throwable handlerException(Throwable e) {
//        if (e instanceof HttpException) {
//            if (((HttpException) e).code() == LOGIN_INVALID_CODE) {//登录异常
//                return new APIException(LOGIN_INVALID_CODE, LOGIN_INVALID_EXCEPTION);
//            } else {
//                return new APIException(((HttpException) e).code(), SERVER_EXCEPTION);
//            }
//        }
//        if (e instanceof IOException) {
//            if (e instanceof SocketTimeoutException) {
//                return new APIException(NETWORK_CODE, TIME_OUT_EXCEPTION);
//            }
//            return new APIException(NETWORK_CODE, NETWORK_EXCEPTION);
//        }
//        if (e instanceof JSONException) {
//            return (new APIException(JSON_CODE, JSON_EXCEPTION));
//        }
        return e;
    }
}
