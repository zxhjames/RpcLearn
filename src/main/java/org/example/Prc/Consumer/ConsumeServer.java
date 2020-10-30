package org.example.Prc.Consumer;

import org.example.Prc.Provider.Methods.MethodInterface;

import java.net.InetSocketAddress;

/**
 * @program: NacosLearn
 * @description: 客户端
 * @author: 占翔昊
 * @create 2020-10-21 18:50
 **/
public class ConsumeServer {
    public static void main(String[] args) {
        // 调用接口方法
        MethodInterface service = RPCServer.getRemoteProxyObj(MethodInterface.class,new InetSocketAddress("localhost",8088));
        System.out.println(service.GetSum(1,2));
    }
}
