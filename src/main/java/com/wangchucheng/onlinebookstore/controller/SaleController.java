package com.wangchucheng.onlinebookstore.controller;

import com.wangchucheng.onlinebookstore.model.Pagination;
import com.wangchucheng.onlinebookstore.model.Sale;
import com.wangchucheng.onlinebookstore.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/sale")
public class SaleController {
    @Autowired
    private SaleService saleService;

    @GetMapping
    public Pagination <List <Sale>> getSales(@RequestParam @Nullable Long startTime,
                                             @RequestParam @Nullable Long endTime,
                                             @RequestParam int page, @RequestParam int size) {
        Timestamp startTimestamp = null;
        Timestamp endTimestamp = null;
        if (startTime != null) {
            startTimestamp = new Timestamp(startTime);
        }
        if (endTime != null) {
            endTimestamp = new Timestamp(endTime);
        }
        return saleService.selectSales(startTimestamp, endTimestamp, page, size);
    }

    @GetMapping(value = "/user/{userId}")
    public Pagination <List <Sale>> getSalesByUserId(@PathVariable Long userId,
                                              @RequestParam @Nullable Long startTime,
                                              @RequestParam @Nullable Long endTime,
                                              @RequestParam int page, @RequestParam int size) {
        Timestamp startTimestamp = null;
        Timestamp endTimestamp = null;
        if (startTime != null) {
            startTimestamp = new Timestamp(startTime);
        }
        if (endTime != null) {
            endTimestamp = new Timestamp(endTime);
        }
        return saleService.selectSalesByUserId(userId, startTimestamp, endTimestamp, page, size);
    }

    @GetMapping(value = "/book/{isbn}")
    public Pagination <List <Sale>> getSalesByUserId(@PathVariable String isbn,
                                                     @RequestParam @Nullable Long startTime,
                                                     @RequestParam @Nullable Long endTime,
                                                     @RequestParam int page, @RequestParam int size) {
        Timestamp startTimestamp = null;
        Timestamp endTimestamp = null;
        if (startTime != null) {
            startTimestamp = new Timestamp(startTime);
        }
        if (endTime != null) {
            endTimestamp = new Timestamp(endTime);
        }
        return saleService.selectSalesByIsbn(isbn, startTimestamp, endTimestamp, page, size);
    }
}
