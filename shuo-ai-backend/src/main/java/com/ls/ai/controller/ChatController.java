package com.ls.ai.controller;

import jakarta.annotation.Resource;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/chat")
public class ChatController {


    @Resource
    private ChatClient chatClient;

    /**
     * AI对话接口，阻塞式响应
     * @param msg
     * @return
     */
    @GetMapping("/simple")
    public String chatOneSimple(String msg) {

       return chatClient.prompt()
                .user(msg)
                .call()
                .content();
    }


    /**
     * 流式响应
     * @param msg
     * @return
     */
    @GetMapping(value = "/complete",produces = "text/html;charset=UTF-8" )
    public Flux<String> chatOneComplete(String msg) {

        return chatClient.prompt()
                .user(msg)
                .stream()
                .content();
    }
}
