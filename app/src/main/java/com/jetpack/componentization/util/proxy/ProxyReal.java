package com.jetpack.componentization.util.proxy;

import com.jetpack.baselib.util.ToastUtil;

public class ProxyReal{

    public String toProxy(String s) {
        ToastUtil.toast("==proxy==="+s);
        return "11111";
    }
}
