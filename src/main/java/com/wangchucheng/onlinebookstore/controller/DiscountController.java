package com.wangchucheng.onlinebookstore.controller;

import com.wangchucheng.onlinebookstore.model.Discount;
import com.wangchucheng.onlinebookstore.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 网络工程与编程实践
 *
 * @author 王初程
 *
 */

@RestController
@RequestMapping(value = "/discount")
public class DiscountController {
    @Autowired
    private DiscountService discountService;

    @PostMapping
    public boolean postDiscount(@RequestBody Discount discount) {
        return discountService.saveDiscount(discount);
    }

    @GetMapping
    public List <Discount> getDiscounts() {
        return discountService.selectDiscounts();
    }

    @PutMapping(value = "/{discountId}")
    public boolean putCategory(@PathVariable Long discountId, @RequestBody Discount discount) {
        return discountService.updateDiscount(discountId, discount);
    }

    @DeleteMapping(value = "/{discountId}")
    public boolean deleteCategory(@PathVariable Long discountId) {
        return discountService.deleteDiscount(discountId);
    }
}
