package com.github.xuchen93.websocket;

import com.github.xuchen93.common.WebSocketCommon;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.http.QueryStringDecoder;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

/**
 * @author xuchen.wang
 * @date 2023/11/23
 */
@Slf4j
public class WebSocketAuthHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

    public WebSocketAuthHandler() {
        log.info("WebSocketAuthHandler Construct");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest msg) throws Exception {
        Map<String, List<String>> parameters = new QueryStringDecoder(msg.uri()).parameters();
        if (!parameters.containsKey("auth")){
            log.info("鉴权失败");
            ctx.channel().writeAndFlush(new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.UNAUTHORIZED));
            ctx.channel().close();
            return;
        }
        String user = parameters.get("auth").get(0);
        log.info("{} 鉴权通过", user);
        ctx.channel().attr(WebSocketCommon.USER).set(user);
        ctx.fireChannelRead(msg.retain());
    }
}
