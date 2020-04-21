package com.wangchucheng.onlinebookstore.repository;

import com.wangchucheng.onlinebookstore.model.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 网络工程与编程实践
 *
 * @author 王初程
 *
 */

public interface DiscountRepo extends JpaRepository <Discount, Long> {
    Discount findByDiscountId(Long discountId);
}
