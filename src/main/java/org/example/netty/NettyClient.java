package org.example.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyClient {
    public static void main(String[] args) throws InterruptedException {
        //客户端需要一个事件循环组
        NioEventLoopGroup eventExecutors = new NioEventLoopGroup();
        //创建客户端的启动对象
        try {

            Bootstrap bootstrap = new Bootstrap();
            //设置相关参数
            bootstrap.group(eventExecutors). //设置线程组
                    channel(NioSocketChannel.class). //设置客户端通道实现类
                    handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new NettyClientHandler()); //加入自己的处理器
                }
            });
            System.out.println("客户端 ok...");
            //启动客户端去连接服务器，这里涉及到netty的异步模型
            ChannelFuture channelFuture = bootstrap.connect("127.0.0.1", 6668).sync();
            channelFuture.channel().closeFuture().sync();
        }finally {
             eventExecutors.shutdownGracefully();
        }
    }
}
