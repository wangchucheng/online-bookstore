package com.wangchucheng.onlinebookstore.service;

import com.wangchucheng.onlinebookstore.model.Comment;
import com.wangchucheng.onlinebookstore.repository.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepo commentRepo;

    public List <Comment> selectCommentsByIsbn(String isbn) {
        return commentRepo.findAllByIsbn(isbn);
    }

    public List <Comment> selectCommentsByUserId(Long userId) {
        return commentRepo.findAllByUserId(userId);
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
