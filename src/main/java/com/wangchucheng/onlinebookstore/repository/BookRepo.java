package com.wangchucheng.onlinebookstore.repository;

import com.wangchucheng.onlinebookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

import java.util.List;

public interface BookRepo extends JpaRepository <Book, String> {
    @Nullable
    List <Book> findAllByCategory(String category);

    Book findByIsbn(String isbn);
}
