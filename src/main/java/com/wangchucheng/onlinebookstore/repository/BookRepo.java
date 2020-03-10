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

    @Nullable
    Page <Book> findAllByTitleContainingAndPriceGreaterThanEqual(String keyword, double lowestPrice,
                                                                   Pageable pageable);

    @Nullable
    Page <Book> findAllByTitleContainingAndPriceLessThanEqual(String keyword, double highestPrice,
                                                                   Pageable pageable);

    @Nullable
    Page <Book> findAllByTitleContainingAndPriceBetween(String keyword, double lowestPrice,
                                                        double highestPrice, Pageable pageable);
}
