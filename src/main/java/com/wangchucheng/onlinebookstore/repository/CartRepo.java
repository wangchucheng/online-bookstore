package com.wangchucheng.onlinebookstore.repository;

import com.wangchucheng.onlinebookstore.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 网络工程与编程实践
 *
 * @author 王初程
 *
 */

public interface CartRepo extends JpaRepository <Cart, Long> {
    Cart findAllByUserId(Long userId);
}
