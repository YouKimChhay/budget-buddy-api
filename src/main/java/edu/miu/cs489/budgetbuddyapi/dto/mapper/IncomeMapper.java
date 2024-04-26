package edu.miu.cs489.budgetbuddyapi.dto.mapper;

import edu.miu.cs489.budgetbuddyapi.dto.response.IncomeResponse;
import edu.miu.cs489.budgetbuddyapi.model.Income;

import java.util.List;

public class IncomeMapper {

    public static IncomeResponse getIncomeResponse(Income income) {
        return IncomeResponse.builder()
                .incomeId(income.getId())
                .userId(income.getUser().getId())
                .amount(income.getAmount())
                .source(income.getSource())
                .payDate(income.getPayDate())
                .createdAt(income.getCreatedAt())
                .build();
    }

    public static List<IncomeResponse> getIncomeResponse(List<Income> incomes) {
        return incomes.stream()
                .map(income -> getIncomeResponse(income))
                .toList();
    }
}
