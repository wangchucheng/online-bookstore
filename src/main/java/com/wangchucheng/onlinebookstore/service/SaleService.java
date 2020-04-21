package com.wangchucheng.onlinebookstore.service;

import com.wangchucheng.onlinebookstore.model.Pagination;
import com.wangchucheng.onlinebookstore.model.Sale;
import com.wangchucheng.onlinebookstore.repository.SaleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * 网络工程与编程实践
 *
 * @author 王初程
 *
 */

@Service
public class SaleService {
    @Autowired
    private SaleRepo saleRepo;

    public Pagination <List <Sale>> selectSales(Timestamp startTime, Timestamp endTime, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page <Sale> sales;
        if (startTime == null && endTime == null) {
            sales = saleRepo.findAll(pageable);
        } else if (startTime != null && endTime == null) {
            sales = saleRepo.findAllByTimeAfter(startTime, pageable);
        } else if (startTime == null) {
            sales = saleRepo.findAllByTimeBefore(endTime, pageable);
        } else {
            sales = saleRepo.findAllByTimeBetween(startTime, endTime, pageable);
        }
        if (sales != null) {
            return new Pagination <>(sales.getTotalElements(), sales.getTotalPages(), sales.getContent());
        } else {
            return null;
        }
    }

    public Pagination <List <Sale>> selectSalesByUserId(Long userId, Timestamp startTime,
                                                        Timestamp endTime, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page <Sale> sales;
        if (startTime == null && endTime == null) {
            sales = saleRepo.findAllByUserId(userId, pageable);
        } else if (startTime != null && endTime == null) {
            sales = saleRepo.findAllByUserIdAndTimeAfter(userId, startTime, pageable);
        } else if (startTime == null) {
            sales = saleRepo.findAllByUserIdAndTimeBefore(userId, endTime, pageable);
        } else {
            sales = saleRepo.findAllByUserIdAndTimeBetween(userId, startTime, endTime, pageable);
        }
        if (sales != null) {
            return new Pagination <>(sales.getTotalElements(), sales.getTotalPages(), sales.getContent());
        } else {
            return null;
        }
    }

    public Pagination <List <Sale>> selectSalesByIsbn(String isbn, Timestamp startTime,
                                                        Timestamp endTime, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page <Sale> sales;
        if (startTime == null && endTime == null) {
            sales = saleRepo.findAllByIsbn(isbn, pageable);
        } else if (startTime != null && endTime == null) {
            sales = saleRepo.findAllByIsbnAndTimeAfter(isbn, startTime, pageable);
        } else if (startTime == null) {
            sales = saleRepo.findAllByIsbnAndTimeBefore(isbn, endTime, pageable);
        } else {
            sales = saleRepo.findAllByIsbnAndTimeBetween(isbn, startTime, endTime, pageable);
        }
        if (sales != null) {
            return new Pagination <>(sales.getTotalElements(), sales.getTotalPages(), sales.getContent());
        } else {
            return null;
        }
    }
}
