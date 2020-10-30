package org.example.Prc.Provider;

import org.example.Prc.Provider.Methods.MethodInterface;
import org.example.Prc.Provider.Methods.MethodInterfaceImpl;
import org.example.Prc.Registry.ServerRegistryImpl;

import java.io.IOException;

/**
 * @program: NacosLearn
 * @description: 服务端
 * @author: 占翔昊
 * @create 2020-10-21 18:49
 **/
public class ProviderServer {
    public static void main(String[] args) throws IOException {
        ServerRegistryImpl serverRegistry = new ServerRegistryImpl(8088);
        // 注册一个接口方法，key是接口名，value是接口实现类
        serverRegistry.register(MethodInterface.class, MethodInterfaceImpl.class);
        serverRegistry.start();
    }
}
