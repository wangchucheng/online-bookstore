package com.wangchucheng.onlinebookstore.repository;

import com.wangchucheng.onlinebookstore.model.Sale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;

import java.sql.Timestamp;
import java.util.List;

/**
 * 网络工程与编程实践
 *
 * @author 王初程
 *
 */

public interface SaleRepo extends JpaRepository <Sale, Long> {
    @Nullable
    List <Sale> findAllByTimeAfter(Timestamp startTime);

    @Nullable
    List <Sale> findAllByTimeBefore(Timestamp endTime);

    @Nullable
    List <Sale> findAllByTimeBetween(Timestamp startTime, Timestamp endTime);

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

    List <Sale> findAllByOrderId(Long orderId);

    Integer countByTimeBetween(Timestamp startTime, Timestamp endTime);

    @Nullable
    @Query("SELECT SUM (s.paidPrice) FROM Sale s WHERE s.time BETWEEN ?1 AND ?2")
    Double findSalesAmountByTimeBetween(Timestamp startTime, Timestamp endTime);
}
