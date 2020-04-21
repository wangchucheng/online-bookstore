package com.wangchucheng.onlinebookstore.controller;

import com.wangchucheng.onlinebookstore.model.Book;
import com.wangchucheng.onlinebookstore.model.Pagination;
import com.wangchucheng.onlinebookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 网络工程与编程实践
 *
 * @author 王初程
 *
 */

@RestController
@RequestMapping(value = "/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public Pagination <List <Book>> getBooksByCategory(@RequestParam @Nullable String category,
                                                       @RequestParam int page, @RequestParam int size) {
        return bookService.selectBooksByCategory(category, page, size);
    }

    @GetMapping(value = "/{isbn}")
    public Book getBookByIsbn(@PathVariable String isbn) {
        return bookService.selectBookByIsbn(isbn);
    }

    @PostMapping
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
    public boolean putPrice(@PathVariable String isbn, @RequestBody Book book) {
        return bookService.updatePrice(isbn, book.getPrice());
    }
}
