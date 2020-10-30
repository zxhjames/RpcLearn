package org.example.designpattern.Proxy.Statics;

// 代理类
public class StaticProxy implements Shopping{
    private Shopping shopping;

    public StaticProxy(Shopping shopping) {
        this.shopping = shopping;
    }
    @Override
    public void Buy() {
        System.out.println("免费领了一张优惠卷!");
        shopping.Buy();
    }
}
