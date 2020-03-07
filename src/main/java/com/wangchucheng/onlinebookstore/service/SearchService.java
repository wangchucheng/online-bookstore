package com.wangchucheng.onlinebookstore.service;

import com.wangchucheng.onlinebookstore.model.Book;
import com.wangchucheng.onlinebookstore.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.PageRanges;
import java.awt.print.Pageable;
import java.sql.Timestamp;
import java.util.List;

@Service
public class SearchService {
    @Autowired
    private BookRepo bookRepo;

    public List <Book> searchBooksByKeyword(String keyword) {
        return bookRepo.findAllByTitleContaining(keyword);
    }

    public List <Book> searchBooksByTime(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("time").descending());
        return bookRepo.findAll(pageRequest).getContent();
    }

    public List <Book> searchBooksBySales(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by("sales").descending());
        return bookRepo.findAll(pageRequest).getContent();
    }
}
