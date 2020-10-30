package org.example.designpattern.Proxy.Statics;

// 小翔用优惠卷买东西
public class StaticProxyTest {
    public static void main(String[] args) {
        Client client = new Client();
        StaticProxy service = new StaticProxy(client);
        service.Buy();
    }
}
