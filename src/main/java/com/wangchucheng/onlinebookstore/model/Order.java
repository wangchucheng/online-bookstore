package com.wangchucheng.onlinebookstore.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "book_order")
public class Order {
    @Id
    @GeneratedValue
    private Long orderId;

    private Long userId;

    private double originalPrice;

    private double paidPrice;

    private String name;

    private String phone;

    private String address;

    @ElementCollection
    private List <Product> products;

    private String status;

    private Timestamp time;

    public Order() {
    }

    public Order(Long userId, double originalPrice, double paidPrice,
                 String name, String phone, String address,
                 List <Product> products, String status, Timestamp time) {
        this.userId = userId;
        this.originalPrice = originalPrice;
        this.paidPrice = paidPrice;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.products = products;
        this.status = status;
        this.time = time;
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

    public List <Product> getProducts() {
        return products;
    }

    public void setProducts(List <Product> products) {
        this.products = products;
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
