package com.project.ExpenseTracker.Repository;

import com.project.ExpenseTracker.model.UserProfileDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserProfileRepo extends MongoRepository<UserProfileDetails,String> {

}
