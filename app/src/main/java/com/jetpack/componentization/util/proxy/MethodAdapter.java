package com.jetpack.componentization.util.proxy;

public abstract class MethodAdapter<T,R> {
    public abstract R adapt(T t);
}
