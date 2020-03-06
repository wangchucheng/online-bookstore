package com.wangchucheng.onlinebookstore.repository;

import com.wangchucheng.onlinebookstore.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;

import java.util.List;

public interface AddressRepo extends JpaRepository <Address, Long> {
    Address findAllByAddressId(Long addressId);

    @Nullable
    List <Address> findAllByUserId(Long userId);
}
