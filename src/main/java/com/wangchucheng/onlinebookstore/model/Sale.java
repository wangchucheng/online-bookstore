package com.wangchucheng.onlinebookstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Sale {
    @Id
    @GeneratedValue
    private Long saleId;

    private Long orderId;

    private Long userId;

    private double originalPrice;

    private double paidPrice;

    private String isbn;

    private int count;

    private String name;

    private String phone;

    private String address;

    private String status;

    private Timestamp time;

    public Sale() {
    }

    public Sale(Long orderId, Long userId, double originalPrice, double paidPrice,
                String isbn, int count,
                String name, String phone, String address,
                String status, Timestamp time) {
        this.orderId = orderId;
        this.userId = userId;
        this.originalPrice = originalPrice;
        this.paidPrice = paidPrice;
        this.isbn = isbn;
        this.count = count;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.status = status;
        this.time = time;
    }

    public Long getSaleId() {
        return saleId;
    }

    public void setSaleId(Long saleId) {
        this.saleId = saleId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public double getPaidPrice() {
        return paidPrice;
    }

    public void setPaidPrice(double paidPrice) {
        this.paidPrice = paidPrice;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
