package com.lqtweb.statistic_service.mapper;

import com.lqtweb.statistic_service.entity.Statistic;
import com.lqtweb.statistic_service.model.StatisticDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StatisticMapper {
    Statistic toStatistic(StatisticDTO request);
    StatisticDTO toStatisticDTO(Statistic statistic);
}
