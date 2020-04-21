package com.wangchucheng.onlinebookstore.repository;

import com.wangchucheng.onlinebookstore.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

/**
 * 网络工程与编程实践
 *
 * @author 王初程
 *
 */

public interface BookRepo extends JpaRepository <Book, String> {
    @Nullable
    Page <Book> findAllByCategory(String category, Pageable pageable);

    Book findByIsbn(String isbn);

    @Nullable
    Page <Book> findAllByTitleContainingOrCategoryContaining(String title, String category, Pageable pageable);

    @Nullable
    Page <Book> findAllByTitleContainingOrCategoryContainingAndPriceGreaterThanEqual(String title, String category,
                                                                                     double lowestPrice, Pageable pageable);

    @Nullable
    Page <Book> findAllByTitleContainingOrCategoryContainingAndPriceLessThanEqual(String title, String category,
                                                                                  double highestPrice, Pageable pageable);

    @Nullable
    Page <Book> findAllByTitleContainingOrCategoryContainingAndPriceBetween(String title, String category, double lowestPrice,
                                                                            double highestPrice, Pageable pageable);

    @Nullable
    Page <Book> findFirst10ByIsbnContaining(String isbnPart, Pageable pageable);
}
