package com.github.xuchen93.websocket;

import cn.hutool.json.JSONUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xuchen.wang
 * @date 2023/11/23
 */
@Slf4j
public class WebSocketBusiHandler extends SimpleChannelInboundHandler<TextWebSocketFrame > {

    /**
     * 创建ChannelGroup对象存储所有连接的用户
     */
    private static final ChannelGroup GROUP = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    /**
     * 新消息
     */
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, TextWebSocketFrame  msg) throws Exception {
        log.info(msg.getClass()+"");
        log.info(msg.toString());
        log.info(JSONUtil.toJsonStr(msg));
        channelHandlerContext.channel().writeAndFlush(new TextWebSocketFrame("收到消息：" + msg.text()));
    }

    /**
     * 新连接
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        GROUP.add(ctx.channel());
        log.info("新连接：" + ctx.channel());
        log.info("新连接目前活跃数量：" + GROUP.size());
        log.info("全部连接：" + JSONUtil.toJsonStr(GROUP));
        ctx.channel().writeAndFlush(new TextWebSocketFrame("welcome"));
    }

    /**
     * 断开连接
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        GROUP.remove(ctx.channel());
        log.info("断开连接：" + ctx.channel());
        log.info("断开连接目前活跃数量：" + GROUP.size());
        log.info("全部连接：" + JSONUtil.toJsonStr(GROUP));
        ctx.channel().writeAndFlush(new TextWebSocketFrame("goodbye"));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.error("连接异常："+cause.getMessage());
        ctx.close();
    }

    public static ChannelGroup getGROUP() {
        return GROUP;
    }

    public WebSocketBusiHandler() {
        log.info("WebSocketBusiHandler Construct");
    }
}
