package com.jetpack.baselib.base;

import io.reactivex.disposables.Disposable;

public interface IDisposable {
    void addDisposable(Disposable disposable);
}
