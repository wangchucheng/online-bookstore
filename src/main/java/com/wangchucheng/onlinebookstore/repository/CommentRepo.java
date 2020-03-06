package com.wangchucheng.onlinebookstore.repository;

import com.wangchucheng.onlinebookstore.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;

import java.util.List;

public interface CommentRepo extends JpaRepository <Comment, Long> {
    Comment findAllByCommentId(Long commentId);

    @Nullable
    List <Comment> findAllByIsbn(String isbn);

    @Nullable
    List <Comment> findAllByUserId(Long userId);
}
