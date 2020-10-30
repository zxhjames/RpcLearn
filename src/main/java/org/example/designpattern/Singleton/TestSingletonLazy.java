package org.example.designpattern.Singleton;

import java.security.Permission;

/**
 * @program: nettylearn
 * @description: 测试懒汉单例
 * @author: 占翔昊
 * @create 2020-10-12 14:05
 **/
public class TestSingletonLazy {
    public static void main(String[] args) {
        President p1 = President.getInstance();
        p1.getName();
        President p2 = President.getInstance();
        p2.getName();
        if (p1 == p2) {
            System.out.println("他们是同一个对象");
        }else{
            System.out.println("不是同一个");
        }
    }
}
