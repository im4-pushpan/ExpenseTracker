package com.project.ExpenseTracker.Repository;

import com.project.ExpenseTracker.model.TransactionDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionDetailsRepo extends MongoRepository<TransactionDetails, String> {

}
