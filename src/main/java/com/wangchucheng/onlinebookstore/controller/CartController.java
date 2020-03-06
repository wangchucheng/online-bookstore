package com.wangchucheng.onlinebookstore.controller;

import com.wangchucheng.onlinebookstore.model.Product;
import com.wangchucheng.onlinebookstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping(value = "/{userId}")
    public List <Product> getProducts(@PathVariable Long userId) {
        return cartService.selectProducts(userId);
    }

    @PostMapping(value = "/{userId}")
    public boolean postProduct(@PathVariable Long userId, @RequestBody Product product) {
        return cartService.saveProduct(userId, product);
    }

    @PutMapping(value = "/{userId}")
    public boolean putProduct(@PathVariable Long userId, @RequestBody Product product) {
        return cartService.updateProduct(userId, product);
    }

    @DeleteMapping(value = "/{userId}")
    public boolean deleteProducts(@PathVariable Long userId, @RequestBody List <String> isbns) {
        return cartService.deleteProducts(userId, isbns);
    }
}
