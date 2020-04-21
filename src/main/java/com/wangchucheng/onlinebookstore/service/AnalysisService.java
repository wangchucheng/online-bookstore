package com.wangchucheng.onlinebookstore.service;

import com.wangchucheng.onlinebookstore.dto.CategoryRatioDto;
import com.wangchucheng.onlinebookstore.dto.DayRatioDto;
import com.wangchucheng.onlinebookstore.model.MoM;
import com.wangchucheng.onlinebookstore.model.Sale;
import com.wangchucheng.onlinebookstore.repository.BookRepo;
import com.wangchucheng.onlinebookstore.repository.SaleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.time.temporal.TemporalAdjusters.*;

/**
 * 网络工程与编程实践
 *
 * @author 王初程
 *
 */

@Service
public class AnalysisService {
    @Autowired
    private SaleRepo saleRepo;

    @Autowired
    private BookRepo bookRepo;

    public List <CategoryRatioDto> getCategoryRatios(Timestamp startTime, Timestamp endTime) {
        List <Sale> sales;
        if (startTime == null && endTime == null) {
            sales = saleRepo.findAll();
        } else if (startTime != null && endTime == null) {
            sales = saleRepo.findAllByTimeAfter(startTime);
        } else if (startTime == null) {
            sales = saleRepo.findAllByTimeBefore(endTime);
        } else {
            sales = saleRepo.findAllByTimeBetween(startTime, endTime);
        }
        if (sales != null) {
            Map <String, Double> map = new HashMap <>();
            double totalPrice = 0;
            for (Sale sale: sales) {
                String category = bookRepo.findByIsbn(sale.getIsbn()).getCategory();
                totalPrice += sale.getPaidPrice();
                if (map.containsKey(category)) {
                    double money = map.get(category);
                    map.put(category, money + sale.getPaidPrice());
                } else {
                    map.put(category, sale.getPaidPrice());
                }
            }
            List <CategoryRatioDto> ratios = new ArrayList <>();
            for (Map.Entry<String, Double> entry : map.entrySet()) {
                CategoryRatioDto ratio = new CategoryRatioDto(entry.getKey(), entry.getValue(),
                        entry.getValue() / totalPrice);
                ratios.add(ratio);
            }
            return ratios;
        } else {
            return null;
        }
    }

    public List <DayRatioDto> getDayRatios(Timestamp startTime, Timestamp endTime) {
        long tempStart = startTime.getTime() - ((startTime.getTime() / 1000 + 8 * 3600) % 86400) * 1000;
        long tempEnd = endTime.getTime() - ((endTime.getTime() / 1000 + 8 * 3600) % 86400) * 1000;
        int between = (int) ((tempEnd - tempStart) / (24 * 60 * 60 * 1000L));
        List <DayRatioDto> dayRatios = new ArrayList <>();
        for (int i = 0; i <= between; i++) {
            tempEnd = tempStart + 24 * 60 * 60 * 1000L;
            List <DayRatioDto> dayRatio = getDayRatio(new Timestamp(tempStart), new Timestamp(tempEnd));
            if (dayRatio != null) {
                dayRatios.addAll(dayRatio);
            }
            tempStart = tempEnd;
        }
        return dayRatios;
    }

    private List <DayRatioDto> getDayRatio(Timestamp startTime, Timestamp endTime) {
        List <Sale> sales = saleRepo.findAllByTimeBetween(startTime, endTime);
        if (sales != null) {
            Map <String, Double> map = new HashMap <>();
            for (Sale sale: sales) {
                String category = bookRepo.findByIsbn(sale.getIsbn()).getCategory();
                if (map.containsKey(category)) {
                    double money = map.get(category);
                    map.put(category, money + sale.getPaidPrice());
                } else {
                    map.put(category, sale.getPaidPrice());
                }
            }
            List <DayRatioDto> ratios = new ArrayList <>();
            for (Map.Entry<String, Double> entry : map.entrySet()) {
                DayRatioDto ratio = new DayRatioDto(entry.getKey(), entry.getValue(), startTime);
                ratios.add(ratio);
            }
            return ratios;
        } else {
            return null;
        }
    }

    public MoM getMoM(Timestamp timestamp) {
        long timestampLong = timestamp.getTime();
        LocalDateTime thisMonth = LocalDateTime.ofEpochSecond(timestampLong/1000,0, ZoneOffset.ofHours(8));
        Timestamp thisMonthBegin = Timestamp.valueOf(thisMonth.with(firstDayOfMonth()).withHour(0).withSecond(0));
        Timestamp thisMonthEnd = Timestamp.valueOf(thisMonth.with(firstDayOfNextMonth()).withHour(0).withSecond(0));
        LocalDateTime lastMonth = thisMonth.minusMonths(1);
        Timestamp lastMonthBegin = Timestamp.valueOf(lastMonth.with(firstDayOfMonth()).withHour(0).withSecond(0));
        Double thisMonthAmount = saleRepo.findSalesAmountByTimeBetween(thisMonthBegin, thisMonthEnd);
        Double lastMonthAmount = saleRepo.findSalesAmountByTimeBetween(lastMonthBegin, thisMonthBegin);
        Integer thisMonthNumber = saleRepo.countByTimeBetween(thisMonthBegin, thisMonthEnd);
        Integer lastMonthNumber = saleRepo.countByTimeBetween(lastMonthBegin, thisMonthBegin);
        double numRatio;
        double amountRatio;
        if (thisMonthAmount == null) {
            thisMonthAmount = 0.0;
        }
        if (lastMonthNumber == 0) {
            numRatio = 0;
        } else {
            numRatio = (double) thisMonthNumber / lastMonthNumber;
        }
        if (lastMonthAmount == null) {
            amountRatio = 0;
        } else {
            amountRatio = thisMonthAmount / lastMonthAmount;
        }
        return new MoM(thisMonthNumber, thisMonthAmount, numRatio, amountRatio);
    }
}
