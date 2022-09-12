package com.srs.application.dto.response;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
public class LoginResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String username;
    private final String jwtToken;
}
