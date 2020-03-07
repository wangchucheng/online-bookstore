package com.wangchucheng.onlinebookstore.service;

import com.wangchucheng.onlinebookstore.model.Comment;
import com.wangchucheng.onlinebookstore.model.Pagination;
import com.wangchucheng.onlinebookstore.repository.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepo commentRepo;

    public Pagination <List <Comment>> selectCommentsByIsbn(String isbn, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page <Comment> comments = commentRepo.findAllByIsbn(isbn, pageable);
        if (comments != null) {
            return new Pagination <>(comments.getTotalElements(), comments.getTotalPages(), comments.getContent());
        } else {
            return null;
        }
    }

    public Pagination <List <Comment>> selectCommentsByUserId(Long userId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page <Comment> comments = commentRepo.findAllByUserId(userId, pageable);
        if (comments != null) {
            return new Pagination <>(comments.getTotalElements(), comments.getTotalPages(), comments.getContent());
        } else {
            return null;
        }
    }

    public boolean saveComment(Long userId, String isbn, Comment comment) {
        comment.setUserId(userId);
        comment.setIsbn(isbn);
        commentRepo.save(comment);
        return true;
    }

    public boolean updateComment(Long commentId, Comment comment) {
        Comment previousComment = commentRepo.findAllByCommentId(commentId);
        comment.setUserId(previousComment.getUserId());
        comment.setIsbn(previousComment.getIsbn());
        comment.setCommentId(commentId);
        commentRepo.save(comment);
        return true;
    }

    public boolean deleteComment(Long commentId) {
        commentRepo.deleteById(commentId);
        return true;
    }
}
