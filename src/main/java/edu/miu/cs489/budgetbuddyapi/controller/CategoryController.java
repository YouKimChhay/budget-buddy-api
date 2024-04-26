package edu.miu.cs489.budgetbuddyapi.controller;

import edu.miu.cs489.budgetbuddyapi.dto.mapper.CategoryMapper;
import edu.miu.cs489.budgetbuddyapi.dto.response.CategoryResponse;
import edu.miu.cs489.budgetbuddyapi.model.Category;
import edu.miu.cs489.budgetbuddyapi.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users/{userId}/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public CategoryResponse addNewCategory(@PathVariable Long userId, @RequestBody Category category) {
        return CategoryMapper.getCategoryResponse(categoryService.addNewCategory(userId, category));
    }

    @GetMapping
    public List<CategoryResponse> getAllCategories(@PathVariable Long userId) {
        return CategoryMapper.getCategoryResponse(categoryService.getAllCategories(userId));
    }

    @GetMapping("/{categoryId}")
    public CategoryResponse getCategoryById(@PathVariable Long userId, @PathVariable Long categoryId) {
        return CategoryMapper.getCategoryResponse(categoryService.getCategoryById(userId, categoryId));
    }

    @PutMapping("/{categoryId}")
    public CategoryResponse updateCategoryById(@PathVariable Long userId, @PathVariable Long categoryId, @RequestBody Category updatedCategory) {
        return CategoryMapper.getCategoryResponse(categoryService.updateCategoryById(userId, categoryId, updatedCategory));
    }

    @DeleteMapping("/{categoryId}")
    public void deleteCategoryById(@PathVariable Long userId, @PathVariable Long categoryId) {
        categoryService.deleteCategoryById(userId, categoryId);
    }
}
