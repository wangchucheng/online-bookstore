package com.wangchucheng.onlinebookstore.service;

import com.wangchucheng.onlinebookstore.dto.AddressDto;
import com.wangchucheng.onlinebookstore.model.Address;
import com.wangchucheng.onlinebookstore.repository.AddressRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List <AddressDto> selectAddressesByUserId(Long userId) {
        ModelMapper modelMapper = new ModelMapper();
        List <Address> address = addressRepo.findAllByUserId(userId);
        Type dtoType = new TypeToken <List <AddressDto>>(){}.getType();
        if (address != null) {
            return modelMapper.map(address, dtoType);
        } else {
            return null;
        }
    }

    public boolean deleteByAddressId(Long addressId) {
        addressRepo.deleteById(addressId);
        return true;
    }
}
