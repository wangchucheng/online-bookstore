package com.wangchucheng.onlinebookstore.repository;

import com.wangchucheng.onlinebookstore.model.Carousel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarouselRepo extends JpaRepository <Carousel, Long> {
    Carousel findByCarouselId(Long carouselId);
}
