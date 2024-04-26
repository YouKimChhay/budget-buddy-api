package edu.miu.cs489.budgetbuddyapi.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class AuthResponse {
    private Long id;
    private String username;
    private String email;
    private String accessToken;
    private LocalDateTime createdAt;
}
