package com.wangchucheng.onlinebookstore.repository;

import com.wangchucheng.onlinebookstore.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepo extends JpaRepository <Cart, Long> {
    Cart findAllByUserId(Long userId);
}
