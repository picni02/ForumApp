package com.example.web_250.services.implementation;

import java.util.List;
import java.util.stream.Collectors;

import com.example.web_250.models.entities.Category;
import com.example.web_250.models.in.CategoryIn;
import com.example.web_250.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.web_250.models.out.CategoryOut;
import com.example.web_250.repositories.CategoryRepository;

@Service
public class CategoryServiceImplementation implements CategoryService {

    @Autowired
    private CategoryRepository _CategoryRepository;

    @Override
    public List<CategoryOut> getAllCategories() {
        return _CategoryRepository.findAll().stream().map(CategoryOut::new).collect(Collectors.toList());
    }

    @Override
    public CategoryOut getCategoryById(int id) {
        try {
            if(_CategoryRepository.findById(id) == null) throw new Exception("Category did not found.");
            return new CategoryOut(_CategoryRepository.findById(id));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Category getCategory(int id) {
        return _CategoryRepository.findById(id);
    }

    @Override
    public CategoryOut addNewCategory(CategoryIn categoryIn) {
        List<CategoryOut> addedCategorys = this.getAllCategories();
        Category temp;
        try {
            temp = new Category(categoryIn);
            for(CategoryOut Category : addedCategorys) if(Category.getName().equals(temp.getName())) throw new Exception("Category already exists");
            _CategoryRepository.save(temp);
            return new CategoryOut(temp);
        } catch(Exception e) {}
        return null;
    }

    @Override
    public CategoryOut editCategory(CategoryIn categoryIn) {
        _CategoryRepository.save(new Category(categoryIn));
        return null;
    }
}
