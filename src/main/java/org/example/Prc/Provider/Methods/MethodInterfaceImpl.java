package org.example.Prc.Provider.Methods;

/**
 * 服务提供者接口实现方法
 **/
public class MethodInterfaceImpl implements MethodInterface {
    @Override
    public int GetSum(int a, int b) {
        return a + b;
    }
}
