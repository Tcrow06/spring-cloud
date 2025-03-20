package com.lqtweb.account_service.controller;

import com.lqtweb.account_service.client.NotificationService;
import com.lqtweb.account_service.client.StatisticService;
import com.lqtweb.account_service.dto.MessageDTO;
import com.lqtweb.account_service.dto.StatisticDTO;
import com.lqtweb.account_service.dto.request.AccountRequest;
import com.lqtweb.account_service.dto.request.AccountUpdateRequest;
import com.lqtweb.account_service.dto.response.AccountResponse;
import com.lqtweb.account_service.dto.response.ApiResponse;
import com.lqtweb.account_service.service.AccountService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AccountController {
    AccountService accountService;
    StatisticService statisticService;
    NotificationService notificationService;
    @PostMapping("/account")
    public ApiResponse<AccountResponse> addAccount(@RequestBody AccountRequest request) {

        statisticService.add(new StatisticDTO("Account "+ request.getName() + " is created", new Date()));

        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setFrom("tcrow0604@gmail.com");
        messageDTO.setTo(request.getUsername());
        messageDTO.setToName(request.getName());
        messageDTO.setSubject("welcome to thinh");
        messageDTO.setContent("Luong Quang Thinh");

        notificationService.sendNotification(messageDTO);
        return ApiResponse.<AccountResponse>builder()
                .result(accountService.add(request))
                .build();
    }

    // get all
    @GetMapping("/accounts")
    public ApiResponse<List<AccountResponse>> getAll() {
        statisticService.add(new StatisticDTO("Get All accounts", new Date()));
        return ApiResponse.<List<AccountResponse>>builder()
                .result(accountService.getAll())
                .build();
    }

    @GetMapping("/account/{id}")
    public ApiResponse<AccountResponse> get(@PathVariable(name = "id") Long id) {
        return ApiResponse.<AccountResponse>builder()
                .result(accountService.getOne(id))
                .build();
    }

    @DeleteMapping("/account/{id}")
    public void delete(@PathVariable(name = "id") Long id) {
        accountService.delete(id);
    }

    @PutMapping("/account")
    public void update(@RequestBody AccountUpdateRequest request) {
        accountService.update(request);
    }
}
