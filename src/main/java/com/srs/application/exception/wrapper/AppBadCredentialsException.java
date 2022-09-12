package com.srs.application.exception.wrapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AppBadCredentialsException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AppBadCredentialsException(String message) {
        super(message);
    }
}
