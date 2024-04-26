package edu.miu.cs489.budgetbuddyapi.dto.mapper;

import edu.miu.cs489.budgetbuddyapi.dto.response.CategoryResponse;
import edu.miu.cs489.budgetbuddyapi.model.Category;

import java.util.List;

public class CategoryMapper {

    public static CategoryResponse getCategoryResponse(Category category) {
        return CategoryResponse.builder()
                .categoryId(category.getId())
                .userId(category.getUser().getId())
                .name(category.getName())
                .description(category.getDescription())
                .budget(category.getBudget())
                .createdAt(category.getCreatedAt())
                .build();
    }

    public static List<CategoryResponse> getCategoryResponse(List<Category> categories) {
        return categories.stream()
                .map(category -> getCategoryResponse(category))
                .toList();
    }
}
