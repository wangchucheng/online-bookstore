package com.wangchucheng.onlinebookstore.service;

import com.wangchucheng.onlinebookstore.model.Discount;
import com.wangchucheng.onlinebookstore.repository.DiscountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountService {
    @Autowired
    private DiscountRepo discountRepo;

    public boolean saveDiscount(Discount discount) {
        discountRepo.save(discount);
        return true;
    }

    public List <Discount> selectDiscounts() {
        return discountRepo.findAll();
    }

    public boolean updateDiscount(Long discountId, Discount discount) {
        discount.setDiscountId(discountId);
        discountRepo.save(discount);
        return true;
    }

    public boolean deleteDiscount(Long discountId) {
        discountRepo.deleteById(discountId);
        return true;
    }
}
