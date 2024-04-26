package edu.miu.cs489.budgetbuddyapi.controller;

import edu.miu.cs489.budgetbuddyapi.dto.mapper.IncomeMapper;
import edu.miu.cs489.budgetbuddyapi.dto.response.IncomeResponse;
import edu.miu.cs489.budgetbuddyapi.model.Income;
import edu.miu.cs489.budgetbuddyapi.service.IncomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users/{userId}/incomes")
@RequiredArgsConstructor
public class IncomeController {

    private final IncomeService incomeService;

    @GetMapping
    public List<IncomeResponse> getAllIncomes(@PathVariable Long userId) {
        return IncomeMapper.getIncomeResponse(incomeService.getAllIncomes(userId));
    }

    @PostMapping
    public IncomeResponse addNewIncome(@PathVariable Long userId, @RequestBody Income income) {
        return IncomeMapper.getIncomeResponse(incomeService.addNewIncome(userId, income));
    }

    @GetMapping("/{incomeId}")
    public IncomeResponse getIncomeById(@PathVariable Long userId, @PathVariable Long incomeId) {
        return IncomeMapper.getIncomeResponse(incomeService.getIncomeById(userId, incomeId));
    }

    @PutMapping("/{incomeId}")
    public IncomeResponse updateIncomeById(@PathVariable Long userId, @PathVariable Long incomeId, @RequestBody Income updatedIncome) {
        return IncomeMapper.getIncomeResponse(incomeService.updateIncomeById(userId, incomeId, updatedIncome));
    }

    @DeleteMapping("/{incomeId}")
    public void deleteIncomeById(@PathVariable Long userId, @PathVariable Long incomeId) {
        incomeService.deleteIncomeById(userId, incomeId);
    }

}
