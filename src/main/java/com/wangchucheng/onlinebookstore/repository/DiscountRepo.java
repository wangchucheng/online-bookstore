package com.wangchucheng.onlinebookstore.repository;

import com.wangchucheng.onlinebookstore.model.Discount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscountRepo extends JpaRepository <Discount, Long> {
    Discount findByDiscountId(Long discountId);
}
