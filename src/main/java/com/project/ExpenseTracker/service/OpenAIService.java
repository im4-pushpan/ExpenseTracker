package com.project.ExpenseTracker.service;

import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OpenAIService {


    private final OpenAiChatClient chatClient;

    @Autowired
    public OpenAIService(OpenAiChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public String generate(String message) {
        return chatClient.call(message);
    }

}
