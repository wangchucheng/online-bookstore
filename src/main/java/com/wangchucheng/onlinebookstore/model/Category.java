package com.wangchucheng.onlinebookstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 网络工程与编程实践
 *
 * @author 王初程
 *
 */

@Entity
public class Category {
    @Id
    @GeneratedValue
    private Long categoryId;

    private String category;

    public Category() {
    }

    public Category(String category) {
        this.category = category;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
