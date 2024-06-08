package com.project.ExpenseTracker.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.List;

@Data
@Document(collection = "user_profile")
public class UserProfileDetails{
    @Id
    @Email
    @Indexed(unique = true)
    private String email;
    @NotEmpty
    @Pattern(regexp = "^[A-Za-z0-9_]*$")
    private String username;
    @NotEmpty
    private String password;
    private List<String> accounts;
}
