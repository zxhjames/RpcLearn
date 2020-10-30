package org.example.designpattern.Proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;

/**
 * @program: nettylearn
 * @description: 第三种代理方法
 * @author: 占翔昊
 * @create 2020-10-29 21:04
 **/
public class ProxyUtil2<T> {
    public static <T> T getProxy2(final Class<?> serviceInterface) {
        return (T) Proxy.newProxyInstance(serviceInterface.getClassLoader(), new Class<?>[]{serviceInterface},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("before 调用");
                        new SoftEngineer().goWorking(args[0].toString(),args[1].toString());
                        System.out.println("after 调用");
                        return null;
                    }
                });
    }
}
