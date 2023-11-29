package com.github.xuchen93.websocket;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xuchen.wang
 * @date 2023/11/23
 */
@Slf4j
public class WebSocketChannelInit extends ChannelInitializer<SocketChannel> {

//    HttpServerCodec httpServerCodec = new HttpServerCodec();
//    ChunkedWriteHandler chunkedWriteHandler = new ChunkedWriteHandler();
//    HttpObjectAggregator httpObjectAggregator = new HttpObjectAggregator(1024*64);
//    WebSocketAuthHandler webSocketAuthHandler = new WebSocketAuthHandler();
//    WebSocketServerProtocolHandler webSocketServerProtocolHandler = new WebSocketServerProtocolHandler("/myWs");
//    WebSocketBusiHandler webSocketBusiHandler = new WebSocketBusiHandler();

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        log.info("init channel");
        ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addLast(new HttpServerCodec())
                .addLast(new ChunkedWriteHandler())
                .addLast(new HttpObjectAggregator(1024*64))
                .addLast(new WebSocketAuthHandler())
                .addLast(new WebSocketServerProtocolHandler("/myWs",true))
                .addLast(new WebSocketBusiHandler())
        ;

    }
}
