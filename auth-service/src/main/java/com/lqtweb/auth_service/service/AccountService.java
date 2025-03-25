package com.lqtweb.auth_service.service;

import com.lqtweb.auth_service.entity.Account;
import com.lqtweb.auth_service.repository.AccountRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AccountService implements UserDetailsService {

    AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username);
        if(account == null){
            throw  new UsernameNotFoundException("No user");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        account.getRoles().forEach((role->{
            authorities.add(new SimpleGrantedAuthority(role));
        }));
        return new User(account.getUsername(), account.getPassword(), authorities);
    }
}
