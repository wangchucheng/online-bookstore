package com.wangchucheng.onlinebookstore.service;

import com.wangchucheng.onlinebookstore.model.Cart;
import com.wangchucheng.onlinebookstore.model.Product;
import com.wangchucheng.onlinebookstore.repository.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 网络工程与编程实践
 *
 * @author 王初程
 *
 */

@Service
public class CartService {
    @Autowired
    private CartRepo cartRepo;

    public boolean initCart(Long userId) {
        Cart cart = new Cart(userId);
        cartRepo.save(cart);
        return true;
    }

    public boolean saveProduct(Long userId, Product product) {
        if(product.getIsbn() == null || product.getCount() == 0) {
            return false;
        } else {
            Cart cart = cartRepo.findAllByUserId(userId);
            List <Product> products = cart.getProducts();
            products.add(product);
            cart.setProducts(products);
            cartRepo.save(cart);
            return true;
        }
    }

    public List <Product> selectProducts(Long userId) {
        Cart cart = cartRepo.findAllByUserId(userId);
        return cart.getProducts();
    }

    public boolean updateProduct(Long userId, Product product) {
        Cart cart = cartRepo.findAllByUserId(userId);
        List <Product> products = cart.getProducts();
        for(Product tempProduct: products) {
            if(tempProduct.getIsbn().equals(product.getIsbn())) {
                tempProduct.setCount(product.getCount());
            }
        }
        cart.setProducts(products);
        cartRepo.save(cart);
        return true;
    }

    public boolean deleteProducts(Long userId, List <String> isbns) {
        Cart cart = cartRepo.findAllByUserId(userId);
        List <Product> products = cart.getProducts();
        for(String isbn: isbns) {
            products.removeIf(product -> isbn.equals(product.getIsbn()));
        }
        cart.setProducts(products);
        cartRepo.save(cart);
        return true;
    }
}
