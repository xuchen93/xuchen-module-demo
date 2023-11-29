package com.github.xuchen93.config;

import com.github.xuchen93.websocket.WebSocketChannelInit;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author xuchen.wang
 * @date 2023/11/23
 */
@Slf4j
@Component
public class WebSocketStarter implements ApplicationListener<ApplicationStartedEvent> {

    @SneakyThrows
    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        ServerBootstrap serverBootstrap = new ServerBootstrap()
                .group(new NioEventLoopGroup(1), new NioEventLoopGroup(4))
                .channel(NioServerSocketChannel.class)
                .childHandler(new WebSocketChannelInit());
        serverBootstrap.bind(9999)
                .addListener(future -> {
                    if (future.isSuccess()){
                        log.info("启动websocket成功");
                    } else {
                        log.error("启动websocket失败");
                    }
                }).sync()
                .channel().closeFuture().addListener(future -> {
                    if (future.isSuccess()){
                        log.info("关闭websocket成功");
                    } else {
                        log.error("关闭websocket失败");
                    }
                });
    }
}
