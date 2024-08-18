package com.project.ExpenseTracker.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "transaction_details")
public class TransactionDetails {

     @Id
     private String transactionId;
     private String username;
     private String accountNumber;
     private String beneficiaryName;
     private String type;
     private Double amount;
     private String category;
}
