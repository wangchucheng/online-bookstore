package com.wangchucheng.onlinebookstore.service;

import com.wangchucheng.onlinebookstore.model.Book;
import com.wangchucheng.onlinebookstore.model.Pagination;
import com.wangchucheng.onlinebookstore.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 网络工程与编程实践
 *
 * @author 王初程
 *
 */

@Service
public class SearchService {
    @Autowired
    private BookRepo bookRepo;

    public Pagination <List <Book>> searchBooksByKeyword(String keyword, String order, Double lowestPrice,
                                                         Double highestPrice, int page, int size) {
        Sort sort;
        switch (order) {
            case "title":
                sort = Sort.by("title");
                break;
            case "price":
                sort = Sort.by("price");
                break;
            case "price_desc":
                sort = Sort.by("price").descending();
                break;
            case "sales":
                sort = Sort.by("sales");
                break;
            case "sales_desc":
                sort = Sort.by("sales").descending();
                break;
            default:
                sort = Sort.by("time").descending();
        }

        Pageable pageable = PageRequest.of(page, size, sort);
        Page <Book> books;
        if (lowestPrice == null && highestPrice == null) {
            books = bookRepo.findAllByTitleContainingOrCategoryContaining(keyword, keyword, pageable);
        } else if (lowestPrice != null && highestPrice == null) {
            books = bookRepo.findAllByTitleContainingOrCategoryContainingAndPriceGreaterThanEqual(keyword, keyword,
                    lowestPrice, pageable);
        } else if (lowestPrice == null) {
            books = bookRepo.findAllByTitleContainingOrCategoryContainingAndPriceLessThanEqual(keyword, keyword,
                    highestPrice, pageable);
        } else {
            books = bookRepo.findAllByTitleContainingOrCategoryContainingAndPriceBetween(keyword, keyword,
                    lowestPrice, highestPrice, pageable);
        }

        if (books != null) {
            return new Pagination <>(books.getTotalElements(), books.getTotalPages(), books.getContent());
        } else {
            return null;
        }
    }

    public Pagination <List <Book>> searchBooksByTime(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("time").descending());
        Page <Book> books = bookRepo.findAll(pageable);
        return new Pagination <>(books.getTotalElements(), books.getTotalPages(), books.getContent());
    }

    public Pagination <List <Book>> searchBooksBySales(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("sales").descending());
        Page <Book> books = bookRepo.findAll(pageable);
        return new Pagination <>(books.getTotalElements(), books.getTotalPages(), books.getContent());
    }
}
