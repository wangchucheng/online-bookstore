package com.wangchucheng.onlinebookstore.service;

import com.wangchucheng.onlinebookstore.dto.AddressDto;
import com.wangchucheng.onlinebookstore.model.Address;
import com.wangchucheng.onlinebookstore.model.Pagination;
import com.wangchucheng.onlinebookstore.repository.AddressRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepo addressRepo;

    public boolean saveAddress(Address address) {
        addressRepo.save(address);
        return true;
    }

    public Pagination <List <AddressDto>> selectAddressesByUserId(Long userId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page <Address> address = addressRepo.findAllByUserId(userId, pageable);
        Type dtoType = new TypeToken <List <AddressDto>>(){}.getType();
        ModelMapper modelMapper = new ModelMapper();
        if (address != null) {
            return new Pagination <>(address.getTotalElements(), address.getTotalPages(),
                    modelMapper.map(address.getContent(), dtoType));
        } else {
            return null;
        }
    }

    public boolean updateAddress(Long addressId, Address address) {
        Address previousAddress = addressRepo.findAllByAddressId(addressId);
        address.setUserId(previousAddress.getUserId());
        address.setAddressId(addressId);
        addressRepo.save(address);
        return true;
    }

    public boolean deleteAddressByAddressId(Long addressId) {
        addressRepo.deleteById(addressId);
        return true;
    }
}
