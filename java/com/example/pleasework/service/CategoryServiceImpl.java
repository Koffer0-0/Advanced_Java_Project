package com.example.pleasework.service;

import com.example.pleasework.model.Category;
import com.example.pleasework.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllAccounts() {
        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category) {
        this.categoryRepository.save(category);
    }

    @Override
    public Category getCategoryById(Integer id) {
        Optional<Category> optionalAccount = categoryRepository.findById(id);
        Category category = null;
        if (optionalAccount.isPresent()) {
            category = optionalAccount.get();
        } else {
            throw new RuntimeException("Employee with " + id + " does not found");
        }
        return category;
    }

    @Override
    public void deleteCategoryById(Integer id) {
        this.categoryRepository.deleteById(id);
    }
}
