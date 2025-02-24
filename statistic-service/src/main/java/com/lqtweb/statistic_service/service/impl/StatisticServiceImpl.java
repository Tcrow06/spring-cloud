package com.lqtweb.statistic_service.service.impl;

import com.lqtweb.statistic_service.entity.Statistic;
import com.lqtweb.statistic_service.mapper.StatisticMapper;
import com.lqtweb.statistic_service.model.StatisticDTO;
import com.lqtweb.statistic_service.repository.StatisticRepository;
import com.lqtweb.statistic_service.service.StatisticService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
class StatisticServiceImpl implements StatisticService {
    StatisticRepository statisticRepository;

    StatisticMapper statisticMapper;

    @Override
    public void add(StatisticDTO statisticDTO) {
        Statistic statistic = statisticMapper.toStatistic(statisticDTO);
        statisticRepository.save(statistic);
    }

    @Override
    public List<StatisticDTO> getAll() {
        List<StatisticDTO> statisticDTOs = new ArrayList<>();

        statisticRepository.findAll().forEach((statistic) -> {
            statisticDTOs.add(statisticMapper.toStatisticDTO(statistic));
        });

        return statisticDTOs;
    }
}
