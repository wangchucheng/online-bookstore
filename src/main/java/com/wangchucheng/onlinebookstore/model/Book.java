package com.wangchucheng.onlinebookstore.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Book {
    @Id
    private String isbn;

    private String title;

    private String coverUrl;

    private double price;

    private String introduction;

    private int sales;

    private String author;

    private String category;

    private int stock;

    private Timestamp time;

    public Book() {
    }

    public Book(String isbn, String title, String coverUrl, double price, String introduction,
                int sales, String author, String category, int stock, Timestamp time) {
        this.isbn = isbn;
        this.title = title;
        this.coverUrl = coverUrl;
        this.price = price;
        this.introduction = introduction;
        this.sales = sales;
        this.author = author;
        this.category = category;
        this.stock = stock;
        this.time = time;
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

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
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

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
