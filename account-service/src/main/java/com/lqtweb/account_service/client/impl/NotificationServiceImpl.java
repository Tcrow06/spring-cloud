package com.lqtweb.account_service.client.impl;

import com.lqtweb.account_service.client.NotificationService;
import com.lqtweb.account_service.dto.MessageDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class NotificationServiceImpl implements NotificationService {
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public void sendNotification(MessageDTO messageDTO){
        //hàm fallback
        logger.error("Notification Service is slow");
    }
}
