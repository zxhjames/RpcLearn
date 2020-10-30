package org.example.Prc.Test;

import org.example.Prc.Consumer.RPCServer;
import org.example.Prc.Provider.Methods.MethodInterface;
import org.example.Prc.Provider.Methods.MethodInterfaceImpl;
import org.example.Prc.Registry.ServerRegistryImpl;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * @program: NacosLearn
 * @description: RPC的测试类
 * @author: 占翔昊
 * @create 2020-10-21 14:34
 **/
public class RPCTest {
    public static void main(String[] args) {
        // 启动一个线程去注册中心注册一个方法
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 启动注册中心
                    ServerRegistryImpl serverRegistry = new ServerRegistryImpl(8088);
                    // 注册一个接口方法，key是接口名，value是接口实现类
                    serverRegistry.register(MethodInterface.class, MethodInterfaceImpl.class);
                    serverRegistry.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // 调用接口方法
        MethodInterface service = RPCServer.getRemoteProxyObj(MethodInterface.class,new InetSocketAddress("localhost",8088));
        System.out.println(service.GetSum(1,2));
    }
}
