package com.wangchucheng.onlinebookstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 网络工程与编程实践
 *
 * @author 王初程
 *
 */

@Entity
public class Carousel {
    @Id
    @GeneratedValue
    private Long carouselId;

    private String carouselUrl;

    public Carousel() {
    }

    public Carousel(String carouselUrl) {
        this.carouselUrl = carouselUrl;
    }

    public Long getCarouselId() {
        return carouselId;
    }

    public void setCarouselId(Long carouselId) {
        this.carouselId = carouselId;
    }

    public String getCarouselUrl() {
        return carouselUrl;
    }

    public void setCarouselUrl(String carouselUrl) {
        this.carouselUrl = carouselUrl;
    }
}