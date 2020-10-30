package org.example.designpattern.Proxy.Statics;

// 买衣服接口
public class Client implements Shopping{
    @Override
    public void Buy() {
        System.out.println("小翔买了衣服");
    }
}
