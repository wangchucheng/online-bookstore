package com.wangchucheng.onlinebookstore.controller;

import com.wangchucheng.onlinebookstore.dto.CategoryRatioDto;
import com.wangchucheng.onlinebookstore.dto.DayRatioDto;
import com.wangchucheng.onlinebookstore.model.MoM;
import com.wangchucheng.onlinebookstore.service.AnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

/**
 * 网络工程与编程实践
 *
 * @author 王初程
 *
 */

@RestController
@RequestMapping(value = "/analysis")
public class AnalysisController {
    @Autowired
    private AnalysisService analysisService;

    @GetMapping(value = "/category")
    public List <CategoryRatioDto> getCategoryRatios(@RequestParam @Nullable Long startTime,
                                                     @RequestParam @Nullable Long endTime) {
        Timestamp startTimestamp = null;
        Timestamp endTimestamp = null;
        if (startTime != null) {
            startTimestamp = new Timestamp(startTime);
        }
        if (endTime != null) {
            endTimestamp = new Timestamp(endTime);
        }
        return analysisService.getCategoryRatios(startTimestamp, endTimestamp);
    }

    @GetMapping(value = "/day")
    public List <DayRatioDto> getDayRatios(@RequestParam Long startTime,
                                           @RequestParam Long endTime) {
        return analysisService.getDayRatios(new Timestamp(startTime), new Timestamp(endTime));
    }

    @GetMapping(value = "/mom")
    public MoM getMoM(@RequestParam Long time) {
        Timestamp timestamp = new Timestamp(time);
        return analysisService.getMoM(timestamp);
    }
}
