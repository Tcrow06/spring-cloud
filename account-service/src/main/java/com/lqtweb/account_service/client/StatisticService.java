package com.lqtweb.account_service.client;

import com.lqtweb.account_service.client.impl.StatisticServiceImpl;
import com.lqtweb.account_service.dto.StatisticDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@FeignClient(name = "statistic-service", url = "http://localhost:9082", fallback = StatisticServiceImpl.class)
//name đặt như thế nào cũng được thông thường là đặt tên trùng với cái
// application name mà đã đặt bên statistic service bơỉ vì mình dùng discordy để đi tìm
//Url là trỏ tới port của statistic service

//(Như bài openfeign thì đã fix cứng url nhưng giờ đăng kí discovery nên không cần phải trỏ url )
//Vì dùng đăng ký discovery server để quản lý instance nên không cần trỏ url
@FeignClient(name = "statistic-service", fallback = StatisticServiceImpl.class)
@Primary
public interface StatisticService {
    //để gọi api controller từ phía statistic service thì ta copy cái api từ controller qua và copy cái statisticDTO sang package model
    @PostMapping("/statistic")
    void add(@RequestBody StatisticDTO statisticDTO); // không cần trả về kiểu dữ liệu cũng được

    // Đã xog , Openfeign đã giúp chúng ta gọi đến api của statistic service (server)
}




