package com.wangchucheng.onlinebookstore.repository;

import com.wangchucheng.onlinebookstore.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

public interface BookRepo extends JpaRepository <Book, String> {
    @Nullable
    Page <Book> findAllByCategory(String category, Pageable pageable);

    Book findByIsbn(String isbn);

    @Nullable
    Page <Book> findAllByTitleContaining(String keyword, Pageable pageable);
}
