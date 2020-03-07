package com.wangchucheng.onlinebookstore.service;

import com.wangchucheng.onlinebookstore.model.Book;
import com.wangchucheng.onlinebookstore.model.Order;
import com.wangchucheng.onlinebookstore.model.Pagination;
import com.wangchucheng.onlinebookstore.model.Product;
import com.wangchucheng.onlinebookstore.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private BookService bookService;

    public boolean saveOrder(Long userId, Order order) {
        for (Product product: order.getProducts()) {
            int stock = bookService.selectBookByIsbn(product.getIsbn()).getStock();
            if (stock < product.getCount()) {
                return false;
            }
        }
        order.setStatus("已付款");
        order.setUserId(userId);
        orderRepo.save(order);
        for (Product product: order.getProducts()) {
            bookService.updateStockAndSales(product.getIsbn(), product.getCount());
        }
        return true;
    }

    public Pagination <List <Order>> selectOrders(Long userId, Timestamp startTime,
                                                  Timestamp endTime, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page <Order> orders;
        if (startTime == null && endTime == null) {
            orders = orderRepo.findAllByUserId(userId, pageable);
        } else if (startTime != null && endTime == null) {
            orders = orderRepo.findAllByUserIdAndTimeAfter(userId, startTime, pageable);
        } else if (startTime == null) {
            orders = orderRepo.findAllByUserIdAndTimeBefore(userId, endTime, pageable);
        } else {
            orders = orderRepo.findAllByUserIdAndTimeBetween(userId, startTime, endTime, pageable);
        }
        if (orders != null) {
            return new Pagination <>(orders.getTotalElements(), orders.getTotalPages(), orders.getContent());
        } else {
            return null;
        }
    }
}
