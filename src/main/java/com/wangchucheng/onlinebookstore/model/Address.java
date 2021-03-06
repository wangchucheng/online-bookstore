package com.wangchucheng.onlinebookstore.model;

import javax.persistence.Column;
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
public class Address {
    @Id
    @GeneratedValue
    private Long addressId;

    @Column(nullable = false)
    private Long userId;

    private String name;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String address;

    public Address() {
    }

    public Address(Long addressId, Long userId, String name, String phone, String address) {
        this.addressId = addressId;
        this.userId = userId;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long id) {
        this.addressId = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
}
