package com.jetpack.componentization.util.proxy;

public abstract class HttpMethod<T> {
    abstract T invoke(Object[] args);
}
