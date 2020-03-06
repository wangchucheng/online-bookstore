package com.wangchucheng.onlinebookstore.model;

import javax.persistence.Embeddable;

@Embeddable
public class Product {
    private String isbn;
    private int count;

    public Product() {
    }

    public Product(String isbn, int count) {
        this.isbn = isbn;
        this.count = count;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
