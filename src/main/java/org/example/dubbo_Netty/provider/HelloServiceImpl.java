package org.example.dubbo_Netty.provider;

import org.example.dubbo_Netty.publicInterface.HelloService;

public class HelloServiceImpl implements HelloService {

    @Override
    public String Hello(String msg) {
        System.out.println("收到客户端信息=" + msg);
        //根据msg返回不同的结果
        if (msg != null) {
            return "你好客户端，我已经收到你的消息";
        }
        return "消息为空";
    }
}
