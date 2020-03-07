package com.wangchucheng.onlinebookstore.model;

import java.sql.Timestamp;

public class Ratio {
    private String category;
    private double money;
    private double ratio;
    private Timestamp time;

    public Ratio() {
    }

    public Ratio(String category, double money, double ratio) {
        this.category = category;
        this.money = money;
        this.ratio = ratio;
    }

    public Ratio(String category, double money, Timestamp time) {
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

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
