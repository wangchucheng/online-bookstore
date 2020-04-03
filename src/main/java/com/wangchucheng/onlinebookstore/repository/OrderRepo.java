package com.wangchucheng.onlinebookstore.repository;

import com.wangchucheng.onlinebookstore.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

import java.sql.Timestamp;

public interface OrderRepo extends JpaRepository <Order, Long> {
    @Nullable
    Page <Order> findAllByUserId(Long userId, Pageable pageable);

    @Nullable
    Page <Order> findAllByUserIdAndTimeAfter(Long userId, Timestamp startTime, Pageable pageable);

    @Nullable
    Page <Order> findAllByUserIdAndTimeBefore(Long userId, Timestamp endTime, Pageable pageable);

    @Nullable
    Page <Order> findAllByUserIdAndTimeBetween(Long userId, Timestamp startTime,
                                               Timestamp endTime, Pageable pageable);

    @Nullable
    Page <Order> findAllByUserIdAndStatus(Long userId, String status, Pageable pageable);

    @Nullable
    Page <Order> findAllByUserIdAndStatusAndTimeAfter(Long userId, String status,
                                                      Timestamp startTime, Pageable pageable);

    @Nullable
    Page <Order> findAllByUserIdAndStatusAndTimeBefore(Long userId, String status,
                                                       Timestamp endTime, Pageable pageable);

    @Nullable
    Page <Order> findAllByUserIdAndStatusAndTimeBetween(Long userId, String status, Timestamp startTime,
                                               Timestamp endTime, Pageable pageable);
}
