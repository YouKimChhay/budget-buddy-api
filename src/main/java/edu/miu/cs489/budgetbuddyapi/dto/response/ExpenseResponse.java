package edu.miu.cs489.budgetbuddyapi.dto.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class ExpenseResponse {
    private Long expenseId;
    private Long userId;
    private String name;
    private String description;
    private double amount;
    private LocalDate paymentDate;
    private String categoryName;
    private LocalDateTime createdAt;
}
