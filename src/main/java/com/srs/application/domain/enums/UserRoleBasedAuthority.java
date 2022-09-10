package com.srs.application.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Optional;

@RequiredArgsConstructor
@Getter
public enum UserRoleBasedAuthority {

    CUSTOMER("ROLE_CUSTOMER"),
    WORKER("ROLE_WORKER"),
    MANAGER("ROLE_MANAGER"),
    OWNER("ROLE_OWNER");

    private final String role;

    public static UserRoleBasedAuthority toEnum (String valueAsString) {
        return Arrays.stream(UserRoleBasedAuthority.values()).filter(value ->
             value.name().equals(valueAsString)
        ).findFirst().get();
    }
}
