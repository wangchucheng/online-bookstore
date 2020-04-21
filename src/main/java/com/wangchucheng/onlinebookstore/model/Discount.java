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
public class Discount {
    @Id
    @GeneratedValue
    private Long discountId;

    private double total;

    private double discount;

    public Discount() {
    }

    public Discount(double total, double discount) {
        this.total = total;
        this.discount = discount;
    }

    public Long getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Long discountId) {
        this.discountId = discountId;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
