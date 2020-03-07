package com.wangchucheng.onlinebookstore.service;

import com.wangchucheng.onlinebookstore.model.*;
import com.wangchucheng.onlinebookstore.repository.OrderRepo;
import com.wangchucheng.onlinebookstore.repository.SaleRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private BookService bookService;

    @Autowired
    private SaleRepo saleRepo;

    public boolean saveOrder(Long userId, Order order) {
        List <Double> prices = new ArrayList <>();
        for (Product product: order.getProducts()) {
            Book book = bookService.selectBookByIsbn(product.getIsbn());
            if (book.getStock() < product.getCount()) {
                return false;
            }
            double price = book.getPrice() * product.getCount();
            prices.add(price);
        }
        order.setStatus("已付款");
        order.setUserId(userId);
        orderRepo.save(order);
        for (Product product: order.getProducts()) {
            bookService.updateStockAndSales(product.getIsbn(), product.getCount());
            //生成sale
            ModelMapper modelMapper = new ModelMapper();
            Sale sale = modelMapper.map(order, Sale.class);
            sale.setIsbn(product.getIsbn());
            sale.setCount(product.getCount());
            sale.setOriginalPrice(prices.get(0));
            sale.setPaidPrice(order.getPaidPrice() * prices.get(0) / order.getOriginalPrice());
            prices.remove(0);
            saleRepo.save(sale);
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
