package org.example.dubbo_Netty.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import org.example.dubbo_Netty.provider.HelloServiceImpl;

/**
 *@description
 *@params  服务器的处理器
 *@return
 *@author  占翔昊
 *@create  2020/10/6
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    // 获取客户端发送的消息并调用服务
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
        //获取客户端发送的消息并调用服务
        System.out.println("msg=" + msg);
        //客户端在调用服务器的api时，我们需要定义一个协议
        //规定每次消息都必须某一个字符串(协议的头部)开头 "helloService#hello#"
        if (msg.toString().startsWith("HelloService#hello#")) {
            String result = new HelloServiceImpl().Hello(msg.toString().substring(msg.toString().lastIndexOf("#") + 1));
            //消息回显
            ctx.writeAndFlush(result);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
