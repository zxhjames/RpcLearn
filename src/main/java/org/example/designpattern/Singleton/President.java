package org.example.designpattern.Singleton;

/**
 * @program: nettylearn
 * @description: 总统类
 * @author: 占翔昊
 * @create 2020-10-12 14:05
 **/
public class President {
    private static volatile President instance = null;
    private President(){
        System.out.println("找到爸爸");
    }
    public static synchronized President getInstance()
    {
        if (instance == null) {
            instance = new President();
        }else{
            System.out.println("已经有一个爸爸了");
        }
        return instance;
    }
    public void getName() {
        System.out.println("我有一个爸爸了");
    }
}
