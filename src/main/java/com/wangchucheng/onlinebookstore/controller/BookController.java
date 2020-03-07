package com.wangchucheng.onlinebookstore.controller;

import com.wangchucheng.onlinebookstore.model.Book;
import com.wangchucheng.onlinebookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping()
    public List <Book> getBooksByCategory(@RequestParam @Nullable String category) {
        return bookService.selectBooksByCategory(category);
    }

    @GetMapping(value = "/{isbn}")
    public Book getBookByIsbn(@PathVariable String isbn) {
        return bookService.selectBookByIsbn(isbn);
    }

    @PostMapping()
    public boolean postBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @PutMapping(value = "/{isbn}")
    public boolean putBook(@PathVariable String isbn, @RequestBody Book book) {
        return bookService.updateBook(isbn, book);
    }

    @DeleteMapping(value = "/{isbn}")
    public boolean deleteBook(@PathVariable String isbn) {
        return bookService.deleteBook(isbn);
    }

    @PutMapping(value = "/{isbn}/price")
    public boolean putPrice(@PathVariable String isbn, @RequestBody double price) {
        return bookService.updatePrice(isbn, price);
    }
}