package com.wangchucheng.onlinebookstore.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {
    @Id
    private String isbn;

    private String title;

    private String coverUrl;

    private double price;

    private int sales;

    private String author;

    private String category;

    private int stock;

    public Book() {
    }

    public Book(String isbn, String title, String coverUrl, double price,
                int sales, String author, String category, int stock) {
        this.isbn = isbn;
        this.title = title;
        this.coverUrl = coverUrl;
        this.price = price;
        this.sales = sales;
        this.author = author;
        this.category = category;
        this.stock = stock;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int number) {
        this.stock = number;
    }
}
