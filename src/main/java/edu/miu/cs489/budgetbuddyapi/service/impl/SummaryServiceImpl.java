package edu.miu.cs489.budgetbuddyapi.service.impl;

import edu.miu.cs489.budgetbuddyapi.dto.response.SummaryResponse;
import edu.miu.cs489.budgetbuddyapi.dto.response.TotalExpensePerCategoryResponse;
import edu.miu.cs489.budgetbuddyapi.model.Category;
import edu.miu.cs489.budgetbuddyapi.model.Expense;
import edu.miu.cs489.budgetbuddyapi.model.Income;
import edu.miu.cs489.budgetbuddyapi.repository.CategoryRepository;
import edu.miu.cs489.budgetbuddyapi.repository.ExpenseRepository;
import edu.miu.cs489.budgetbuddyapi.repository.IncomeRepository;
import edu.miu.cs489.budgetbuddyapi.service.SummaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SummaryServiceImpl implements SummaryService {

    private final IncomeRepository incomeRepository;
    private final ExpenseRepository expenseRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public SummaryResponse getSummaryByUserId(Long userId, int year, int month) {
        // find the start and end period
        LocalDate start = LocalDate.of(year, month, 1);
        LocalDate end = LocalDate.of(year, month, start.lengthOfMonth());

        // find total income
        List<Income> incomes = incomeRepository.findIncomesByUserIdAndPayDateBetween(userId, start, end);
        double totalIncome = incomes.stream()
                .mapToDouble(Income::getAmount)
                .sum();

        // find total expense
        List<Expense> expenses = expenseRepository.findExpensesByUserIdAndPaymentDateBetween(userId, start, end);
        double totalExpense = expenses.stream()
                .mapToDouble(Expense::getAmount)
                .sum();

        // find total expense per category
        List<Category> categories = categoryRepository.findCategoriesByUserId(userId);
        List<TotalExpensePerCategoryResponse> totalExpensePerCategoryList = categories.stream()
                .map(category -> TotalExpensePerCategoryResponse.builder()
                        .categoryName(category.getName())
                        .budget(category.getBudget())
                        .totalExpense(expenseRepository.findExpensesByUserIdAndCategoryIdAndPaymentDateBetween(userId, category.getId(), start, end).stream()
                                .mapToDouble(Expense::getAmount).sum())
                        .build()
                ).toList();

        return SummaryResponse.builder()
                .userId(userId)
                .totalIncome(totalIncome)
                .totalExpense(totalExpense)
                .totalExpensePerCategoryList(totalExpensePerCategoryList)
                .build();
    }

}
