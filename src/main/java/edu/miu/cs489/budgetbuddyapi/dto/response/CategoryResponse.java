package edu.miu.cs489.budgetbuddyapi.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CategoryResponse {
    private Long categoryId;
    private Long userId;
    private String name;
    private String description;
    private double budget;
    private LocalDateTime createdAt;
}
