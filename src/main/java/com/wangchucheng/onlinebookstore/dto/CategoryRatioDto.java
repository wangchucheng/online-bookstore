package com.wangchucheng.onlinebookstore.dto;

/**
 * 网络工程与编程实践
 *
 * @author 王初程
 *
 */

public class CategoryRatioDto {
    private String category;
    private double money;
    private double ratio;

    public CategoryRatioDto() {
    }

    public CategoryRatioDto(String category, double money, double ratio) {
        this.category = category;
        this.money = money;
        this.ratio = ratio;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }
}
