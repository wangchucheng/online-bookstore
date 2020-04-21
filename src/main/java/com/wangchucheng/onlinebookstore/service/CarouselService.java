package com.wangchucheng.onlinebookstore.service;

import com.wangchucheng.onlinebookstore.model.Carousel;
import com.wangchucheng.onlinebookstore.repository.CarouselRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 网络工程与编程实践
 *
 * @author 王初程
 *
 */

@Service
public class CarouselService {
    @Autowired
    private CarouselRepo carouselRepo;

    public boolean saveCarousel(Carousel carousel) {
        carouselRepo.save(carousel);
        return true;
    }

    public List <Carousel> selectCarousels() {
        return carouselRepo.findAll();
    }

    public boolean updateCarousel(Long carouselId, Carousel carousel) {
        carousel.setCarouselId(carouselId);
        carouselRepo.save(carousel);
        return true;
    }

    public boolean deleteCarousel(Long carouselId) {
        carouselRepo.deleteById(carouselId);
        return true;
    }
}
