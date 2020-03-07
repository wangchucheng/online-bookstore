package com.wangchucheng.onlinebookstore.controller;

import com.wangchucheng.onlinebookstore.model.Book;
import com.wangchucheng.onlinebookstore.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/search")
public class SearchController {
    @Autowired
    private SearchService searchService;

    @GetMapping()
    public List <Book> getBooksBykeyWord(@RequestParam String keyword) {
        return searchService.searchBooksByKeyword(keyword);
    }

    @GetMapping(value = "/time")
    public List <Book> getBooksByTime(@RequestParam int page, @RequestParam int size) {
        return searchService.searchBooksByTime(page, size);
    }

    @GetMapping(value = "/sales")
    public List <Book> getBooksBySales(@RequestParam int page, @RequestParam int size) {
        return searchService.searchBooksBySales(page, size);
    }
}
