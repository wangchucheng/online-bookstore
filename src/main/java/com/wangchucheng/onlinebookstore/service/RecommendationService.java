package com.wangchucheng.onlinebookstore.service;

import com.wangchucheng.onlinebookstore.model.Book;
import com.wangchucheng.onlinebookstore.model.Pagination;
import com.wangchucheng.onlinebookstore.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationService {
    @Autowired
    private BookRepo bookRepo;

    public Pagination <List <Book>> selectBooksByUserId(Long userId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page <Book> books = bookRepo.findFirst10ByIsbnContaining(userId.toString(), pageable);
        if (books != null) {
            return new Pagination <>(books.getTotalElements(), books.getTotalPages(), books.getContent());
        } else {
            return null;
        }
    }
}
