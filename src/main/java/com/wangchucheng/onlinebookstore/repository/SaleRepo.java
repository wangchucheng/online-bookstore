package com.wangchucheng.onlinebookstore.repository;

import com.wangchucheng.onlinebookstore.model.Sale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

import java.sql.Timestamp;

public interface SaleRepo extends JpaRepository <Sale, Long> {
    @Nullable
    Page <Sale> findAllByTimeAfter(Timestamp startTime, Pageable pageable);

    @Nullable
    Page <Sale> findAllByTimeBefore(Timestamp endTime, Pageable pageable);

    @Nullable
    Page <Sale> findAllByTimeBetween(Timestamp startTime, Timestamp endTime, Pageable pageable);

    @Nullable
    Page <Sale> findAllByUserId(Long userId, Pageable pageable);

    @Nullable
    Page <Sale> findAllByUserIdAndTimeAfter(Long userId, Timestamp startTime, Pageable pageable);

    @Nullable
    Page <Sale> findAllByUserIdAndTimeBefore(Long userId, Timestamp endTime, Pageable pageable);

    @Nullable
    Page <Sale> findAllByUserIdAndTimeBetween(Long userId, Timestamp startTime,
                                              Timestamp endTime, Pageable pageable);

    @Nullable
    Page <Sale> findAllByIsbn(String isbn, Pageable pageable);

    @Nullable
    Page <Sale> findAllByIsbnAndTimeAfter(String isbn, Timestamp startTime, Pageable pageable);

    @Nullable
    Page <Sale> findAllByIsbnAndTimeBefore(String isbn, Timestamp endTime, Pageable pageable);

    @Nullable
    Page <Sale> findAllByIsbnAndTimeBetween(String isbn, Timestamp startTime,
                                              Timestamp endTime, Pageable pageable);
}
