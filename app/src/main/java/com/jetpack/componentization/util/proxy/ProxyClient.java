package com.jetpack.componentization.util.proxy;

import androidx.annotation.Nullable;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;




public class ProxyClient {
    public ProxyInterface create(Class<ProxyInterface> service){
        return (ProxyInterface) Proxy.newProxyInstance(
                service.getClassLoader(),
                new Class<?>[] {service},
                new InvocationHandler() {
                    private final Object[] emptyArgs = new Object[0];

                    @Override
                    public  Object invoke(Object proxy, Method method, @Nullable Object[] args)
                            throws Throwable {
//                        LogUtil.e("=invoke=proxy===>"+proxy);
//                        LogUtil.e("=invoke=method===>"+method);
//                        LogUtil.e("=invoke=args===>"+args);
                        // If the method is a method from Object then defer to normal invocation.
                        if (method.getDeclaringClass() == Object.class) {

                        }
                        ProxyReal proxyInterface=new ProxyReal();
                        return 12345;//方法的返回值
                    }
                });
    }
}

