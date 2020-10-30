package org.example.dubbo_Netty.customer;

import org.example.dubbo_Netty.netty.NettyClient;
import org.example.dubbo_Netty.publicInterface.HelloService;

/**
 * @program: nettylearn
 * @description: 客户端服务器
 * @author: 占翔昊
 * @create 2020-10-29 19:33
 **/
public class ClientBootstrap {

    //这里定义协议头
    public static final String providerName = "HelloService#hello#james";

    public static void main(String[] args) throws InterruptedException {
        //创建一个消费者
        NettyClient customer = new NettyClient();
        //创建代理对象
        HelloService service = (HelloService) customer.getBean(HelloService.class, providerName);
        //通过代理对象调用服务提供者的方法
        String res = service.Hello("你好 Dubbo");
        System.out.println("调用的结果，res = " + res);
        Thread.sleep(2000);
    }
}

