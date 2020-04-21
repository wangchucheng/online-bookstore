package com.wangchucheng.onlinebookstore.repository;

import com.wangchucheng.onlinebookstore.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.Nullable;

import java.util.List;

/**
 * 网络工程与编程实践
 *
 * @author 王初程
 *
 */

public interface CommentRepo extends JpaRepository <Comment, Long> {
    Comment findAllByCommentId(Long commentId);

    @Nullable
    Page <Comment> findAllByIsbn(String isbn, Pageable pageable);

    @Nullable
    Page <Comment> findAllByUserId(Long userId, Pageable pageable);

    @Query("SELECT c.stars FROM Comment c WHERE c.isbn = ?1")
    List <Integer> findStarsByIsbn(String isbn);
}
