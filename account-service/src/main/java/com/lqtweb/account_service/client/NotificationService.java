package com.lqtweb.account_service.client;

import com.lqtweb.account_service.client.impl.NotificationServiceImpl;
import com.lqtweb.account_service.dto.MessageDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@FeignClient(name = "notification-service", url="http://localhost:9083")
@FeignClient(name = "notification-service", fallback = NotificationServiceImpl.class)
@Primary
public interface NotificationService {

    @PostMapping("/send-notification")
    void sendNotification(@RequestBody MessageDTO messageDTO);
}

