package com.example.web_250.services;

import java.util.List;

import com.example.web_250.models.entities.Category;
import com.example.web_250.models.in.CategoryIn;
import com.example.web_250.models.out.CategoryOut;

public interface CategoryService {
    public List<CategoryOut> getAllCategories();
    public CategoryOut getCategoryById(int id);
    public Category getCategory(int id);
    public CategoryOut addNewCategory(CategoryIn categoryIn);
    public CategoryOut editCategory(CategoryIn categoryIn);
}
