package org.example.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/*
1.我们自定义一个handler，需要继续netty，规定好某个handlerAdapter
2.这时我们定义一个handler，才能称为一个好的handler
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {
    //读取数据实际(这里我们可以读取客户端发送的信息
    /*
    1.ChannelHandlerContext ctx:上下文对象,含有管道pipleline
    2.Object msg:客户端发送的数据,默认Object
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //super.channelRead(ctx, msg);
        System.out.println("服务器读取线程 " + Thread.currentThread().getName());
        System.out.println("server ctx = " + ctx);
        //将msg转为一个ByteBuffer
        ByteBuf byteBuf = (ByteBuf)msg;
        System.out.println("客户端发送消息是:"+byteBuf.toString(CharsetUtil.UTF_8));
        System.out.println("客户端地址是:"+ctx.channel().remoteAddress());
    }

    //数据读取完毕
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        //super.channelReadComplete(ctx);
        //将数据写入到缓存并且刷新
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello client",CharsetUtil.UTF_8));
    }

    //处理异常,关闭通道
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //super.exceptionCaught(ctx, cause);
        ctx.close();
    }
}
