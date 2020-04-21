package com.wangchucheng.onlinebookstore.dto;

import java.sql.Timestamp;

/**
 * 网络工程与编程实践
 *
 * @author 王初程
 *
 */

public class DayRatioDto {
    private String category;
    private double money;
    private Timestamp time;

    public DayRatioDto() {
    }

    public DayRatioDto(Timestamp time) {
        this.time = time;
    }

    public DayRatioDto(String category, double money, Timestamp time) {
        this.category = category;
        this.money = money;
        this.time = time;
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

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
