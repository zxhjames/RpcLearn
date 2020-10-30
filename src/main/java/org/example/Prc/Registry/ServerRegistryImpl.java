package org.example.Prc.Registry;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 服务注册中心实现类
 **/

public class ServerRegistryImpl implements ServerRegistry {
//    private static ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    private static ExecutorService executor = Executors.newCachedThreadPool();
    private static final HashMap<String,Class> serviceRegistry = new HashMap<String,Class>();
    private static int port;
    public ServerRegistryImpl(int port) {
        this.port = port;
    }
    @Override
    public void stop() {
        executor.shutdown();
    }

    @Override
    public void start() throws IOException {
        ServerSocket server = new ServerSocket();
        server.bind(new InetSocketAddress(port));
        System.out.println("当前已经注册的服务");
        for (Map.Entry<String, Class> entry : serviceRegistry.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue().getName();
            System.out.println("key=" + key + " value=" + value);
        }
        try {
            while (true) {
                // 循环监听客户端的tcp连接，接到tcp连接后直接封装为task,由线程池去执行
                executor.execute(new ServiceTask(server.accept()));
            }
        } finally {
            server.close();
            executor.shutdown();
        }

    }

    @Override
    public void register(Class serviceInterface, Class Impl) {
        // 服务列表注册到注册中心的hash表里
        serviceRegistry.put(serviceInterface.getName(),Impl);
    }


    // 循环执行服务任务
    public static class ServiceTask implements Runnable {
        Socket client = null;
        public ServiceTask(Socket client) {
            this.client = client;
        }
        @Override
        public void run() {
            // todo 这两个类的方法作用
            ObjectInputStream input = null;
            ObjectOutputStream output = null;
            try {
                // 将客户端发送的码流反序列化为对象，反射调用服务实现者，获取执行结果
                input = new ObjectInputStream(client.getInputStream());
                String serviceName = input.readUTF();
                String methodName = input.readUTF();
                Class<?>[] parameterTypes = (Class<?>[]) input.readObject();
                Object[] arguments = (Object[]) input.readObject();

                // 获取注册中心的实体类
                Class serviceClass = serviceRegistry.get(serviceName);
                if (serviceClass == null) {
                    throw new ClassNotFoundException(serviceName + " not found");
                }
                Method method = serviceClass.getMethod(methodName,parameterTypes);
                Object result = method.invoke(serviceClass.newInstance(),arguments);

                // 将执行结果反序列化，通过socket发送给客户端
                output = new ObjectOutputStream(client.getOutputStream());
                output.writeObject(result);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (output != null) {
                    try {
                        output.close();
                    }catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if (input != null) {
                    try {
                        input.close();
                    }catch (IOException e) {
                        e.printStackTrace();
                   }
                }

                if (client != null) {
                    try {
                        client.close();
                    }catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
