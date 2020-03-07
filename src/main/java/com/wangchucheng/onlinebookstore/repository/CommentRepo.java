package com.wangchucheng.onlinebookstore.repository;

import com.wangchucheng.onlinebookstore.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

public interface CommentRepo extends JpaRepository <Comment, Long> {
    Comment findAllByCommentId(Long commentId);

    @Nullable
    Page <Comment> findAllByIsbn(String isbn, Pageable pageable);

    @Nullable
    Page <Comment> findAllByUserId(Long userId, Pageable pageable);
}
