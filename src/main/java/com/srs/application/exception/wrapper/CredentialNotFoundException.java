package com.srs.application.exception.wrapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CredentialNotFoundException extends RuntimeException {
    public CredentialNotFoundException(String message) {
        super(message);
    }
}
