package com.project.ExpenseTracker.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "transaction_details")
public class TransactionDetails {
     private String username;
     private String transactionId;
     private String accountNumber;
     private String beneficiaryName;
     private String type;
     private Double amount;
     private String category;
}
