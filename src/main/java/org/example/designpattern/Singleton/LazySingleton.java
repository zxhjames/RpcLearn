package org.example.designpattern.Singleton;

/**
 * @program: nettylearn
 * @description: 懒汉式单例
 * @author: 占翔昊
 * @create 2020-10-12 13:57
 **/
public class LazySingleton {
    private static volatile LazySingleton instance = null;
    private LazySingleton(){}
    public static synchronized LazySingleton getInstance()
    {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
