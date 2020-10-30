package org.example.designpattern.Singleton;

/**
 * @program: nettylearn
 * @description: 饿汉式单例
 * @author: 占翔昊
 * @create 2020-10-12 14:01
 **/
public class HungrySingleton {
    private static final HungrySingleton instance = new HungrySingleton();
    private HungrySingleton(){}
    public static HungrySingleton getInstance(){
        return instance;
    }
}
