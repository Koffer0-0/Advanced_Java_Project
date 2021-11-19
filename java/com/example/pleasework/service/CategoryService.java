package com.example.pleasework.service;

import com.example.pleasework.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAllAccounts();

    void createCategory(Category category);

    Category getCategoryById(Integer id);

    void deleteCategoryById(Integer id);


}
