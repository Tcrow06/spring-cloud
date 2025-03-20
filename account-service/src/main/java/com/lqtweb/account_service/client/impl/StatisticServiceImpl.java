package com.lqtweb.account_service.client.impl;

import com.lqtweb.account_service.client.StatisticService;
import com.lqtweb.account_service.dto.StatisticDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component //class này phải tạo bean Compoment
public class StatisticServiceImpl implements StatisticService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void add (StatisticDTO statisticDTO){
        //Hàm fallback theo ý muốn
        //Hiện tại đơn giản chỉ in ra hàm logger
        logger.error("Statistic Service is slow");
    }
}