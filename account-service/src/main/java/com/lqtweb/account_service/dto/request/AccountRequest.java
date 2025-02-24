package com.lqtweb.account_service.dto.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountRequest {

     String name;

     String password;

     String username;

     Set<String> roles;
}
