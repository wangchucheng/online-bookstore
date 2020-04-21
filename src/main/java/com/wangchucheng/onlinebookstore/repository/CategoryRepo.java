package com.wangchucheng.onlinebookstore.repository;

import com.wangchucheng.onlinebookstore.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 网络工程与编程实践
 *
 * @author 王初程
 *
 */

public interface CategoryRepo extends JpaRepository <Category, Long> {
    Category findByCategoryId(Long categoryId);
}
