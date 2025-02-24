package com.lqtweb.account_service.dto.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountUpdateRequest {
     Long id;
     String name;

     Set<String> roles;
}
