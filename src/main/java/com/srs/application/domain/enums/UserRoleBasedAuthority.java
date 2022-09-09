package com.srs.application.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum UserRoleBasedAuthority {

    CUSTOMER("ROLE_CUSTOMER"),
    WORKER("ROLE_WORKER"),
    MANAGER("ROLE_MANAGER"),
    OWNER("ROLE_OWNER");

    private final String role;
}
