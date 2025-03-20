package com.lqtweb.account_service.dto;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class StatisticDTO {
    private Long id;
    @NonNull
    private String message;
    @NonNull
    private Date createdDate;
}
