package com.wangchucheng.onlinebookstore.controller;

import com.wangchucheng.onlinebookstore.model.Comment;
import com.wangchucheng.onlinebookstore.model.Pagination;
import com.wangchucheng.onlinebookstore.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 网络工程与编程实践
 *
 * @author 王初程
 *
 */

@RestController
@RequestMapping(value = "/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping(value = "/book/{isbn}")
    public Pagination <List <Comment>> getCommentsByIsbn(@PathVariable String isbn, @RequestParam int page,
                                                         @RequestParam int size) {
        return commentService.selectCommentsByIsbn(isbn, page, size);
    }

    @GetMapping(value = "/book/{isbn}/stars")
    public double getStarByIsbn(@PathVariable String isbn) {
        return commentService.selectStarByIsbn(isbn);
    }

    @GetMapping(value = "user/{userId}")
    public Pagination <List <Comment>> getCommentsByUserId(@PathVariable Long userId, @RequestParam int page,
                                                           @RequestParam int size) {
        return commentService.selectCommentsByUserId(userId, page, size);
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
