package com.project.ExpenseTracker.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.ExpenseTracker.Repository.TransactionDetailsRepo;
import com.project.ExpenseTracker.model.TransactionDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class HuggingFaceAIService {

    @Autowired
    TransactionDetailsRepo transactionDetailsRepo;

    @Value("${huggingface.mistral.apikey}")
    private String API_KEY;
    @Value("${huggingface.mistral.baseurl}")
    private String BASE_URL;


    public String generate(String message) {
//        message.replace();
        HttpClient client = HttpClient.newHttpClient();

        // Create payload
        String payload = "{\"inputs\":\"[INST] You are a helpful code assistant. Your task is to generate a valid JSON object based on the given information:you are provide with text Like this text:"+
        message.replace("\"","")+
        " you need to extract details like accountNumber,type(debit/credit),transactionId,amount,beneficiaryName in text accountNumber is represented by A/C and TransactionId as Refno Just generate the JSON object without explanations like{transactionId:value,accountNumber:value,type:value,amount:value,beneficiaryName:value} if attribute is unknown make that attribute value as null[/INST]\"}";

        // Create request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL))
                .headers("Content-Type", "application/json")
                .headers("Accept", "application/json")
                .headers("Authorization","Bearer "+API_KEY)
                .POST(HttpRequest.BodyPublishers.ofString(payload))
                .build();

        try {
            // Send request and get response
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            String genratedResponse = response.body().replace("\\n","").replace("\\","");
            String regex = "\\[/INST\\]\\s*(\\{.*?\\})";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(genratedResponse);
            if (matcher.find()) {
                ObjectMapper mapper = new ObjectMapper();
                TransactionDetails transaction = mapper.readValue(matcher.group(1), TransactionDetails.class);
                transactionDetailsRepo.save(transaction);
                return transaction.toString();
            } else {
                System.out.println("No match found.");
                return "fail to create";
            }

        } catch (Exception e) {
            return e.toString();
        }
    }
}
