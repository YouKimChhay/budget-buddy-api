package edu.miu.cs489.budgetbuddyapi.dto.request;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String password;
}