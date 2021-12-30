package com.github.xuchen93.websocket.demo;


import cn.hutool.json.JSONUtil;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.timeout.IdleStateEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.MultiValueMap;
import org.yeauty.annotation.BeforeHandshake;
import org.yeauty.annotation.OnBinary;
import org.yeauty.annotation.OnClose;
import org.yeauty.annotation.OnError;
import org.yeauty.annotation.OnEvent;
import org.yeauty.annotation.OnMessage;
import org.yeauty.annotation.OnOpen;
import org.yeauty.annotation.PathVariable;
import org.yeauty.annotation.RequestParam;
import org.yeauty.annotation.ServerEndpoint;
import org.yeauty.pojo.Session;

import java.io.IOException;
import java.util.Map;

/**
 * @author xuchen.wang
 * @date 2021/12/30
 */
@Slf4j
@ServerEndpoint(path = "/ws/{arg}",port = "8800",allIdleTimeSeconds="10",readerIdleTimeSeconds = "5")
public class WebSocketEndpoint {


	@OnOpen
	public void onOpen(Session session, HttpHeaders headers, @RequestParam String req, @RequestParam MultiValueMap reqMap, @PathVariable String arg, @PathVariable Map pathMap){
		log.info("new connection");
		log.info(req);
		log.info(arg);
		log.info(JSONUtil.toJsonStr(reqMap));
	}

	@OnClose
	public void onClose(Session session) throws IOException {
		log.info("one connection closed");
	}

	@OnError
	public void onError(Session session, Throwable throwable) {
		log.info("one connection error");
		throwable.printStackTrace();
	}

	@OnMessage
	public void onMessage(Session session, String message) {
		log.info(message);
		session.sendText("Hello Netty!");
	}

	@OnBinary
	public void onBinary(Session session, byte[] bytes) {
		log.info("one connection onBinary");
		session.sendBinary(bytes);
	}

	@OnEvent
	public void onEvent(Session session, Object evt) {
		if (evt instanceof IdleStateEvent) {
			IdleStateEvent idleStateEvent = (IdleStateEvent) evt;
			switch (idleStateEvent.state()) {
				case READER_IDLE:
					log.info("read idle");
					break;
				case WRITER_IDLE:
					log.info("write idle");
					break;
				case ALL_IDLE:
					log.info("all idle");
					break;
				default:
					break;
			}
		}
	}

}
