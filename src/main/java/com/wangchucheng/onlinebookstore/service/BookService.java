package com.wangchucheng.onlinebookstore.service;

import com.wangchucheng.onlinebookstore.model.Book;
import com.wangchucheng.onlinebookstore.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;

    public List <Book> selectBooksByCategory(String category) {
        if(category != null) {
            return bookRepo.findAllByCategory(category);
        } else {
            return bookRepo.findAll();
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
}
