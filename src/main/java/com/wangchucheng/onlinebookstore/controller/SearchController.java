package com.wangchucheng.onlinebookstore.controller;

import com.wangchucheng.onlinebookstore.model.Book;
import com.wangchucheng.onlinebookstore.model.Pagination;
import com.wangchucheng.onlinebookstore.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 网络工程与编程实践
 *
 * @author 王初程
 *
 */

@RestController
@RequestMapping(value = "/search")
public class SearchController {
    @Autowired
    private SearchService searchService;

    @GetMapping
    public Pagination <List <Book>> getBooksByKeyWord(@RequestParam String keyword,
                                                      @RequestParam String order,
                                                      @RequestParam @Nullable Double lowestPrice,
                                                      @RequestParam @Nullable Double highestPrice,
                                                      @RequestParam int page, @RequestParam int size) {
        return searchService.searchBooksByKeyword(keyword, order, lowestPrice, highestPrice, page, size);
    }

    @GetMapping(value = "/time")
    public Pagination <List <Book>> getBooksByTime(@RequestParam int page, @RequestParam int size) {
        return searchService.searchBooksByTime(page, size);
    }

    @GetMapping(value = "/sales")
    public Pagination <List <Book>> getBooksBySales(@RequestParam int page, @RequestParam int size) {
        return searchService.searchBooksBySales(page, size);
    }
}
