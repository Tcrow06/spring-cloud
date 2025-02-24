package com.lqtweb.account_service.controller;

import com.lqtweb.account_service.dto.request.AccountRequest;
import com.lqtweb.account_service.dto.request.AccountUpdateRequest;
import com.lqtweb.account_service.dto.response.AccountResponse;
import com.lqtweb.account_service.dto.response.ApiResponse;
import com.lqtweb.account_service.service.AccountService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AccountController {
    AccountService accountService;


    @PostMapping("/account")
    public ApiResponse<AccountResponse> addAccount(@RequestBody AccountRequest request) {
        return ApiResponse.<AccountResponse>builder()
                .result(accountService.add(request))
                .build();
    }

    // get all
    @GetMapping("/accounts")
    public ApiResponse<List<AccountResponse>> getAll() {
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
