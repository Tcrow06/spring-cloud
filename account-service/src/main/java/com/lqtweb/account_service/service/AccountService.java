package com.lqtweb.account_service.service;

import com.lqtweb.account_service.dto.request.AccountRequest;
import com.lqtweb.account_service.dto.request.AccountUpdateRequest;
import com.lqtweb.account_service.dto.request.UpdatePasswordRequest;
import com.lqtweb.account_service.dto.response.AccountResponse;

import java.util.List;

public interface AccountService {
    AccountResponse add(AccountRequest accountDTO);

    void update(AccountUpdateRequest request);

    void updatePassword(UpdatePasswordRequest accountDTO);

    void delete(Long id);

    List<AccountResponse> getAll();

    AccountResponse getOne(Long id);
}
