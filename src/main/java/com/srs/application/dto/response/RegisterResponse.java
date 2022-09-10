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
public class RegisterResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private Boolean isSuccess = true;
    private final String message;
}
