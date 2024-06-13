package com.project.ExpenseTracker.controller;

import com.project.ExpenseTracker.service.HuggingFaceAIService;
import com.project.ExpenseTracker.service.OllamaAIService;
import com.project.ExpenseTracker.service.OpenAIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TransactionMessageProcessingController {

    @Autowired
    private OpenAIService openAIService; // No implemented

    @Autowired
    private OllamaAIService ollamaAIService; // No implemented

    @Autowired
    private HuggingFaceAIService huggingFaceAIservice;

    @PostMapping("/transaction")
    public ResponseEntity<Object> addTransaction(@RequestBody String prompt){
        return new ResponseEntity<>(huggingFaceAIservice.generate(prompt),HttpStatusCode.valueOf(200));
    }
}
