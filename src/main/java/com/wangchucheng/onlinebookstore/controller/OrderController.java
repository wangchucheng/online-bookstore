package com.wangchucheng.onlinebookstore.controller;

import com.wangchucheng.onlinebookstore.model.Order;
import com.wangchucheng.onlinebookstore.model.Pagination;
import com.wangchucheng.onlinebookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping(value = "/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/user/{userId}")
    public boolean postOrder(@PathVariable Long userId, @RequestBody Order order) {
        return orderService.saveOrder(userId, order);
    }

    @GetMapping(value = "/user/{userId}")
    public Pagination <List <Order>> getOrders(@PathVariable Long userId,
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
        return orderService.selectOrders(userId, startTimestamp, endTimestamp, page, size);
    }
}
