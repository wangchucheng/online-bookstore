package com.wangchucheng.onlinebookstore.controller;

import com.wangchucheng.onlinebookstore.model.Comment;
import com.wangchucheng.onlinebookstore.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping(value = "/book/{isbn}")
    public List <Comment> getCommentsByIsbn(@PathVariable String isbn) {
        return commentService.selectCommentsByIsbn(isbn);
    }

    @GetMapping(value = "user/{userId}")
    public List <Comment> getCommentsByUserId(@PathVariable Long userId) {
        return commentService.selectCommentsByUserId(userId);
    }

    @PostMapping(value = "user/{userId}/book/{isbn}")
    public boolean postComment(@PathVariable Long userId, @PathVariable String isbn, @RequestBody Comment comment) {
        return commentService.saveComment(userId, isbn, comment);
    }

    @PutMapping(value = "/{commentId}")
    public boolean putComment(@PathVariable Long commentId, @RequestBody Comment comment) {
        return commentService.updateComment(commentId, comment);
    }

    @DeleteMapping(value = "/{commentId}")
    public boolean deleteComment(@PathVariable Long commentId) {
        return commentService.deleteComment(commentId);
    }
}
