package org.example.designpattern.Proxy.dynamic;

import java.lang.reflect.Proxy;

/**
 * @program: nettylearn
 * @description: 测试动态代理
 * @author: 占翔昊
 * @create 2020-10-29 20:41
 **/
public class Test {
    public static void main(String[] args) {
        // 第一种 简单方式
        Person p = new DynamicProxy(new SoftEngineer()).getProxy();
        p.goWorking("james","school");


        // 第二种 闭包
//        Person p2 = new ProxyUtil1(new SoftEngineer()).getProxyObj();
//        p2.goWorking("james","bed");
//
//        // 第三种，传递class代理
//        Person p3 = ProxyUtil2.getProxy2(Person.class);
//        p3.goWorking("james","lab");
    }
}
