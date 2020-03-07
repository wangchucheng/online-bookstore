package com.wangchucheng.onlinebookstore.repository;

import com.wangchucheng.onlinebookstore.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository <Category, Long> {
    Category findByCategoryId(Long categoryId);
}
