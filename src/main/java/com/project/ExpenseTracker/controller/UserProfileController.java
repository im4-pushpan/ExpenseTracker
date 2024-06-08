package com.project.ExpenseTracker.controller;

import com.project.ExpenseTracker.Repository.UserProfileRepo;
import com.project.ExpenseTracker.model.UserProfileDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserProfileController {

    @Autowired
    UserProfileRepo userProfileRepo;

    @PostMapping("/register")
    public ResponseEntity<Object> userRegister(@RequestBody UserProfileDetails userProfileDetails){
        userProfileRepo.save(userProfileDetails);
        return ResponseEntity.ok(userProfileDetails);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> userLogin(@RequestBody UserProfileDetails userProfileDetails){
        return null;
    }

}
