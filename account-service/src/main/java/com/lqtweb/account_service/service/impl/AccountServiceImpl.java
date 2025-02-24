package com.lqtweb.account_service.service.impl;

import com.lqtweb.account_service.dto.request.AccountRequest;
import com.lqtweb.account_service.dto.request.AccountUpdateRequest;
import com.lqtweb.account_service.dto.request.UpdatePasswordRequest;
import com.lqtweb.account_service.dto.response.AccountResponse;
import com.lqtweb.account_service.entity.Account;
import com.lqtweb.account_service.mapper.AccountMapper;
import com.lqtweb.account_service.repository.AccountRepository;
import com.lqtweb.account_service.service.AccountService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AccountServiceImpl implements AccountService {

    AccountRepository accountRepository;
    AccountMapper accountMapper;
    final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

    @Override
    public AccountResponse add(AccountRequest request) {
        Account account = accountMapper.toAccount(request);
        account.setPassword(passwordEncoder.encode(request.getPassword()));

        return accountMapper.toAccountResponse(accountRepository.save(account));
    }

    @Override
    public void update(AccountUpdateRequest request) {
        Account account = accountRepository.findById(request.getId())
                .orElseThrow(RuntimeException::new);
        accountMapper.updateAccount(account,request);
            accountRepository.save(account);
    }

    @Override
    public void updatePassword(UpdatePasswordRequest request) {
        Account account = accountRepository.findById(request.getId())
                .orElseThrow(RuntimeException::new);
        account.setPassword(passwordEncoder.encode(request.getPassword()));
        accountRepository.save(account);
    }

    @Override
    public void delete(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(RuntimeException::new);
        accountRepository.delete(account);
    }

    @Override
    public List<AccountResponse> getAll() {
        return accountRepository.findAll().stream()
                .map(accountMapper::toAccountResponse).toList();

    }

    @Override
    public AccountResponse getOne(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(RuntimeException::new);
        return accountMapper.toAccountResponse(account);
    }
}
