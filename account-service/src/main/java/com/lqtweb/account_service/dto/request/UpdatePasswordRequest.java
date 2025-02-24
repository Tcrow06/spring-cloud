package com.lqtweb.account_service.dto.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpdatePasswordRequest {
    Long id;
    String username;
    String password;
}
