package com.project.ExpenseTracker.service;

import org.springframework.ai.ollama.OllamaChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OllamaAIService {
    private final OllamaChatClient chatClient;

    @Autowired
    public OllamaAIService(OllamaChatClient  chatClient) {
        this.chatClient = chatClient;
    }

    public String generate(String message) {
        return chatClient.call(message);
    }
}
