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

    @PostMapping(value = "/{userId}")
    public boolean postAddress(@PathVariable Long userId, @RequestBody Address address) {
        address.setUserId(userId);
        return addressService.saveAddress(address);
    }

    @GetMapping(value = "/{userId}")
    public List <AddressDto> getAddresses(@PathVariable Long userId) {
        return addressService.selectAddressesByUserId(userId);
    }

    @PutMapping(value = "/{userId}/{addressId}")
    public boolean putAddress(@PathVariable Long userId, @PathVariable Long addressId,
                              @RequestBody Address address) {
        address.setUserId(userId);
        address.setAddressId(addressId);
        return addressService.saveAddress(address);
    }

    @DeleteMapping(value = "/{userId}/{addressId}")
    public boolean deleteAddress(@PathVariable Long userId, @PathVariable Long addressId) {
        return addressService.deleteByAddressId(addressId);
    }
}
