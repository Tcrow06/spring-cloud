package com.lqtweb.account_service.mapper;

import com.lqtweb.account_service.dto.request.AccountRequest;
import com.lqtweb.account_service.dto.request.AccountUpdateRequest;
import com.lqtweb.account_service.dto.response.AccountResponse;
import com.lqtweb.account_service.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    @Mapping(target = "password",ignore = true)
    Account toAccount(AccountRequest accountRequest);
    AccountResponse toAccountResponse(Account account);
    void updateAccount(@MappingTarget Account account, AccountUpdateRequest request);

}
