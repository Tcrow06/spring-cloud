package com.lqtweb.statistic_service.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class StatisticDTO {
    private Long id;
    private String message;
    private Date createdDate;
}
