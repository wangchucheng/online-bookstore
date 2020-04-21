package com.wangchucheng.onlinebookstore.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 网络工程与编程实践
 *
 * @author 王初程
 *
 */

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class AddressDto {
    private Long addressId;
    private String name;
    private String phone;
    private String address;

    public AddressDto() {
    }

    public AddressDto(Long addressId, String name, String phone, String address) {
        this.addressId = addressId;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
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
