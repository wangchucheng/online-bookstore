package com.wangchucheng.onlinebookstore.repository;

import com.wangchucheng.onlinebookstore.model.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

/**
 * 网络工程与编程实践
 *
 * @author 王初程
 *
 */

public interface AddressRepo extends JpaRepository <Address, Long> {
    Address findAllByAddressId(Long addressId);

    @Nullable
    Page <Address> findAllByUserId(Long userId, Pageable pageable);
}
