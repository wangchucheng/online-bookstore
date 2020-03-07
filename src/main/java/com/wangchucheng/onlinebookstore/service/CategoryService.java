package com.wangchucheng.onlinebookstore.service;

import com.wangchucheng.onlinebookstore.model.Category;
import com.wangchucheng.onlinebookstore.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    public boolean saveCategory(Category category) {
        categoryRepo.save(category);
        return true;
    }

    public List <Category> selectCategories() {
        return categoryRepo.findAll();
    }

    public boolean updateCategory(Long categoryId, Category category) {
        category.setCategoryId(categoryId);
        categoryRepo.save(category);
        return true;
    }

    public boolean deleteCategory(Long categoryId) {
        categoryRepo.deleteById(categoryId);
        return true;
    }
}
