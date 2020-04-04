package com.wangchucheng.onlinebookstore.model;

public class MoM {
    private int number;
    private double amount;
    private double numRatio;
    private double amountRatio;

    public MoM() {
    }

    public MoM(int number, double amount, double numRatio, double amountRatio) {
        this.number = number;
        this.amount = amount;
        this.numRatio = numRatio;
        this.amountRatio = amountRatio;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getNumRatio() {
        return numRatio;
    }

    public void setNumRatio(double numRatio) {
        this.numRatio = numRatio;
    }

    public double getAmountRatio() {
        return amountRatio;
    }

    public void setAmountRatio(double amountRatio) {
        this.amountRatio = amountRatio;
    }
}
