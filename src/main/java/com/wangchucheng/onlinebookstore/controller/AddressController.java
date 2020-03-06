package com.wangchucheng.onlinebookstore.controller;

import com.wangchucheng.onlinebookstore.dto.AddressDto;
import com.wangchucheng.onlinebookstore.model.Address;
import com.wangchucheng.onlinebookstore.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping(value = "/user/{userId}")
    public boolean postAddress(@PathVariable Long userId, @RequestBody Address address) {
        address.setUserId(userId);
        return addressService.saveAddress(address);
    }

    @GetMapping(value = "/user/{userId}")
    public List <AddressDto> getAddresses(@PathVariable Long userId) {
        return addressService.selectAddressesByUserId(userId);
    }

    @PutMapping(value = "/{addressId}")
    public boolean putAddress(@PathVariable Long addressId, @RequestBody Address address) {
        return addressService.updateAddress(addressId, address);
    }

    @DeleteMapping(value = "/{addressId}")
    public boolean deleteAddress(@PathVariable Long addressId) {
        return addressService.deleteAddressByAddressId(addressId);
    }
}
