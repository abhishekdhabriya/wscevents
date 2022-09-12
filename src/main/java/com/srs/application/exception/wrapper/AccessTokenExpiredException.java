package com.srs.application.exception.wrapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AccessTokenExpiredException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public AccessTokenExpiredException(String message) {
        super(message);
    }
}
