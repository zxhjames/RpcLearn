package org.example.dubbo_Netty.provider;

import org.example.dubbo_Netty.netty.NettyServer;

//启动一个服务提供者
public class ServerBootstrap {
    public static void main(String[] args) throws InterruptedException {
        NettyServer.startServer("127.0.0.1",7000);
    }
}
