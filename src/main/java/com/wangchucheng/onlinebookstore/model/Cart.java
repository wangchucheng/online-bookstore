package com.wangchucheng.onlinebookstore.model;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Cart {
    @Id
    private Long userId;

    @ElementCollection
    private List <Product> products;

    public Cart() {
    }

    public Cart(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List <Product> getProducts() {
        return products;
    }

    public void setProducts(List <Product> products) {
        this.products = products;
    }
}
