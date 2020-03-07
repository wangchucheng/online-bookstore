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

@Service
public class SearchService {
    @Autowired
    private BookRepo bookRepo;

    public Pagination <List <Book>> searchBooksByKeyword(String keyword, int page, int size) {
        Pageable pageRequest = PageRequest.of(page, size);
        Page <Book> books = bookRepo.findAllByTitleContaining(keyword, pageRequest);
        if (books != null) {
            return new Pagination <>(books.getTotalElements(), books.getTotalPages(), books.getContent());
        } else {
            return null;
        }
    }

    public Pagination <List <Book>> searchBooksByTime(int page, int size) {
        Pageable pageRequest = PageRequest.of(page, size, Sort.by("time").descending());
        Page <Book> books = bookRepo.findAll(pageRequest);
        return new Pagination <>(books.getTotalElements(), books.getTotalPages(), books.getContent());
    }

    public Pagination <List <Book>> searchBooksBySales(int page, int size) {
        Pageable pageRequest = PageRequest.of(page, size, Sort.by("sales").descending());
        Page <Book> books = bookRepo.findAll(pageRequest);
        return new Pagination <>(books.getTotalElements(), books.getTotalPages(), books.getContent());
    }
}
