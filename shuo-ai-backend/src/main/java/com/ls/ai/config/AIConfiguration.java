package com.ls.ai.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AIConfiguration {

    /**
     * AI服务的客户端
     * @return
     */
    @Bean
    public ChatClient chatClient(OllamaChatModel model) {
        return ChatClient
                .builder(model)
                .defaultAdvisors(new SimpleLoggerAdvisor())  // 日志
                .build();
    }
}
