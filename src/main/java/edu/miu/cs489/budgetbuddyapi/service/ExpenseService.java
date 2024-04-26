package edu.miu.cs489.budgetbuddyapi.service;

import edu.miu.cs489.budgetbuddyapi.model.Expense;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public interface ExpenseService {
    Expense addNewExpense(Long userId, Expense expense);
    List<Expense> getAllExpenses(Long userId, String categoryName);
    Expense getExpenseById(Long userId, Long expenseId) throws EntityNotFoundException;
    Expense updateExpenseById(Long userId, Long expenseId, Expense updatedExpense) throws EntityNotFoundException;
    void deleteExpenseById(Long userId, Long expenseId);
}
