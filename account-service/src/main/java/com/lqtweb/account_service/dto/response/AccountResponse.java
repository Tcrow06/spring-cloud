package com.lqtweb.account_service.dto.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountResponse {
     Long id;

     String name;


     String username;

     Set<String> roles;
}
