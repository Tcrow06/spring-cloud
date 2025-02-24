package com.lqtweb.statistic_service.service;

import com.lqtweb.statistic_service.model.StatisticDTO;

import java.util.List;


public interface StatisticService {
    void add(StatisticDTO statisticDTO);

    List<StatisticDTO> getAll();
}

