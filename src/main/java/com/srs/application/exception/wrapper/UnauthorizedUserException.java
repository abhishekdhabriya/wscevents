package com.srs.application.exception.wrapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UnauthorizedUserException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public UnauthorizedUserException(String message) {
        super(message);
    }
}
