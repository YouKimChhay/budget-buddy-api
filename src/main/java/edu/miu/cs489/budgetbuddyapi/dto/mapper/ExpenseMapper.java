package edu.miu.cs489.budgetbuddyapi.dto.mapper;

import edu.miu.cs489.budgetbuddyapi.dto.response.ExpenseResponse;
import edu.miu.cs489.budgetbuddyapi.model.Expense;

import java.util.List;

public class ExpenseMapper {

    public static ExpenseResponse getExpenseResponse(Expense expense) {
        return ExpenseResponse.builder()
                .expenseId(expense.getId())
                .userId(expense.getUser().getId())
                .name(expense.getName())
                .description(expense.getDescription())
                .amount(expense.getAmount())
                .paymentDate(expense.getPaymentDate())
                .categoryName(expense.getCategory().getName())
                .createdAt(expense.getCreatedAt())
                .build();
    }

    public static List<ExpenseResponse> getExpenseResponse(List<Expense> expenses) {
        return expenses.stream()
                .map(expense -> getExpenseResponse(expense))
                .toList();
    }
}
