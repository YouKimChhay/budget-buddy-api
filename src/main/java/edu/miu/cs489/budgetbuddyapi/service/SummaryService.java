package edu.miu.cs489.budgetbuddyapi.service;

import edu.miu.cs489.budgetbuddyapi.dto.response.SummaryResponse;

public interface SummaryService {
    SummaryResponse getSummaryByUserId(Long userId, int year, int month);
}
