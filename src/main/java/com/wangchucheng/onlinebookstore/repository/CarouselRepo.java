package com.wangchucheng.onlinebookstore.repository;

import com.wangchucheng.onlinebookstore.model.Carousel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 网络工程与编程实践
 *
 * @author 王初程
 *
 */

public interface CarouselRepo extends JpaRepository <Carousel, Long> {
    Carousel findByCarouselId(Long carouselId);
}
