package edu.miu.cs489.budgetbuddyapi.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomResponse<T> {
    private int statusCode;
    private String message;
    private T data;
}
