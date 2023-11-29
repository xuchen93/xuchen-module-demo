package com.github.xuchen93.controller;

import cn.hutool.core.util.StrUtil;
import com.github.xuchen93.websocket.WebSocketBusiHandler;
import com.github.xuchen93.common.WebSocketCommon;
import io.netty.channel.group.ChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuchen.wang
 * @date 2023/11/29
 */
@RestController
@Slf4j
public class WebSocketController {

    @GetMapping("send/{user}")
    public String send(@PathVariable String user, String msg){
        log.info("user=[{}],msg=[{}]",user,msg);
        ChannelGroup group = WebSocketBusiHandler.getGROUP();
        group.stream()
            .filter(c -> c.attr(WebSocketCommon.USER).get().equals(user))
            .forEach(c-> c.writeAndFlush(new TextWebSocketFrame(msg)));
        return StrUtil.format("给[{}]发消息：{}",user,msg);
    }
}
