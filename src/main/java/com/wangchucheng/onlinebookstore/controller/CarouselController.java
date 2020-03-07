package com.wangchucheng.onlinebookstore.controller;

import com.wangchucheng.onlinebookstore.model.Carousel;
import com.wangchucheng.onlinebookstore.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/carousel")
public class CarouselController {
    @Autowired
    private CarouselService carouselService;

    @PostMapping
    public boolean postCarousel(@RequestBody Carousel carousel) {
        return carouselService.saveCarousel(carousel);
    }

    @GetMapping
    public List <Carousel> getCarousels() {
        return carouselService.selectCarousels();
    }

    @PutMapping(value = "/{carouselId}")
    public boolean putCategory(@PathVariable Long carouselId, @RequestBody Carousel carousel) {
        return carouselService.updateCarousel(carouselId, carousel);
    }

    @DeleteMapping(value = "/{carouselId}")
    public boolean deleteCategory(@PathVariable Long carouselId) {
        return carouselService.deleteCarousel(carouselId);
    }
}
