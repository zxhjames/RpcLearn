package org.example.designpattern.Proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @program: nettylearn
 * @description: 代理工具类
 * @author: 占翔昊
 * @create 2020-10-29 20:46
 **/
public class ProxyUtil1 {
    private Object target;


    public ProxyUtil1(Object target) {
        this.target = target;
    }

    public  <T> T getProxyObj() {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("before 调用");
                        Object result = method.invoke(target,args);
                        System.out.println("after 调用");
                        return result;
                    }
                });
    }
}
