package org.example.Prc.Registry;

import java.io.IOException;

/**
 * 服务注册中心
 */
public interface ServerRegistry {
    public void stop();
    public void start() throws IOException;
    public void register(Class serviceInterface,Class Impl);
}
