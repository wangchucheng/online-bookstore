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
public class BookService {
    @Autowired
    private BookRepo bookRepo;

    public Pagination <List <Book>> selectBooksByCategory(String category, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page <Book> books;
        if(category != null) {
            books = bookRepo.findAllByCategory(category, pageable);
        } else {
            books = bookRepo.findAll(pageable);
        }
        if (books != null) {
            return new Pagination <>(books.getTotalElements(), books.getTotalPages(), books.getContent());
        } else {
            return null;
        }
    }

    public Book selectBookByIsbn(String isbn) {
        return bookRepo.findByIsbn(isbn);
    }

    public boolean saveBook(Book book) {
        book.setStock(0);
        bookRepo.save(book);
        return true;
    }

    public boolean updateBook(String isbn, Book book) {
        Book previousBook = bookRepo.findByIsbn(isbn);
        book.setSales(previousBook.getSales());
        book.setTime(previousBook.getTime());
        book.setIsbn(isbn);
        bookRepo.save(book);
        return true;
    }

    public boolean deleteBook(String isbn) {
        bookRepo.deleteById(isbn);
        return true;
    }

    public boolean updatePrice(String isbn, double price) {
        Book book = bookRepo.findByIsbn(isbn);
        book.setPrice(price);
        bookRepo.save(book);
        return true;
    }

    public boolean updateStockAndSales(String isbn, int count) {
        Book book = bookRepo.findByIsbn(isbn);
        book.setStock(book.getStock() - count);
        book.setSales(book.getSales() + count);
        bookRepo.save(book);
        return true;
    }
}
