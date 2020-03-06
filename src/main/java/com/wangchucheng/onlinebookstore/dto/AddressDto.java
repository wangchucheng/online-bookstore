package com.wangchucheng.onlinebookstore.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class AddressDto {
    private Long addressId;
    private String phone;
    private String address;

    public AddressDto() {
    }

    public AddressDto(Long addressId, String phone, String address) {
        this.addressId = addressId;
        this.phone = phone;
        this.address = address;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
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
