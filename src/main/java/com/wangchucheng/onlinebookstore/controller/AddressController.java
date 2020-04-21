package com.wangchucheng.onlinebookstore.controller;

import com.wangchucheng.onlinebookstore.dto.AddressDto;
import com.wangchucheng.onlinebookstore.model.Address;
import com.wangchucheng.onlinebookstore.model.Pagination;
import com.wangchucheng.onlinebookstore.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 网络工程与编程实践
 *
 * @author 王初程
 *
 */

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
    public Pagination <List <AddressDto>> getAddresses(@PathVariable Long userId, @RequestParam int page,
                                                       @RequestParam int size) {
        return addressService.selectAddressesByUserId(userId, page, size);
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
