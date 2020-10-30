package org.example.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyServer {
    public static void main(String[] args) throws InterruptedException {
        //创建两个线程组,创建BossGroup 和 WorkerGroup
        //BossGroup处理连接请求，真正的和客户端业务处理，会交给workerGroup处理，两个都是死循环
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        //创建服务器端的启动对象，配置参数
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup).
                    channel(NioServerSocketChannel.class) //使用NIOSocketChannel作为通信的实现
                    .option(ChannelOption.SO_BACKLOG, 128) //设置线程队列得到连接的个数
                    .childOption(ChannelOption.SO_KEEPALIVE, true) //设置保持活动连接状态
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        //创建一个通道测试对象
                        //给pipline设置处理器
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            //给管道后面加入一个处理器
                            ch.pipeline().addLast(new NettyServerHandler());
                        }
                    }); //给workergroup的eventloop设置处理器
            //服务器准备好了,接下俩准备端口
            System.out.println("server is ready...");
            //绑定一个端口并且同步，生成一个ChannelFuture对象，启动服务器
            ChannelFuture cf = bootstrap.bind(6668).sync();
            //对关闭通道进行监听
            cf.channel().closeFuture().sync();
        }finally {
            //优雅关闭
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
