package org.example.dubbo_Netty.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.Callable;

/**
 * @program: nettylearn
 * @description: 客户端处理器
 * @author: 占翔昊
 * @create 2020-10-29 16:23
 **/
public class NettyClientHandler extends ChannelInboundHandlerAdapter implements Callable {
    private ChannelHandlerContext context; //上下文
    private String result; // 掉方法的结果
    private String param; // 客户端调用传入的参数

    // 调用顺序 channelActive --> setPara --> call --> channelread --> call


    // 创建连接成功后就会被调用
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // 声明一个通用的context
        this.context = ctx;
    }


    // 收到服务器数据后被调用
    @Override
    public synchronized void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        result = msg.toString();
        notify(); // 唤醒等待的线程
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

    // 这个call被代理对象调用，发送数据给服务器，等待数据返回才会唤醒，再返回结果
    @Override
    public synchronized Object call() throws Exception {
        // 发送给服务器消息，但是结果不会马上返回
        context.writeAndFlush(param);
        wait(); // 等待channelread 方法获取到服务器的结果后唤醒
        return result; // 服务端返回的结果
    }

    void setParam(String para) {
        this.param = para;
    }
}
