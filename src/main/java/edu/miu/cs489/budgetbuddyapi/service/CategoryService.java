package edu.miu.cs489.budgetbuddyapi.service;

import edu.miu.cs489.budgetbuddyapi.model.Category;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public interface CategoryService {
    Category addNewCategory(Long userId, Category category);
    List<Category> getAllCategories(Long userId);
    Category getCategoryById(Long userId, Long categoryId) throws EntityNotFoundException;
    Category updateCategoryById(Long userId, Long categoryId, Category updatedCategory) throws EntityNotFoundException;
    void deleteCategoryById(Long userId, Long categoryId);
}
