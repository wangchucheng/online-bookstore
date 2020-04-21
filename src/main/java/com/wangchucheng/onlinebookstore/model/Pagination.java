package com.wangchucheng.onlinebookstore.model;

/**
 * 网络工程与编程实践
 *
 * @author 王初程
 *
 */

public class Pagination <T> {
    private long totalElements;
    private int totalPages;
    private T data;

    public Pagination() {
    }

    public Pagination(Long totalElements, int totalPages, T data) {
        this.totalElements = totalElements;
        this.totalPages = totalPages;
        this.data = data;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
