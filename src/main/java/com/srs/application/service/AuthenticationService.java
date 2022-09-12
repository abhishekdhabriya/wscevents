package com.srs.application.service;

import com.srs.application.dto.request.LoginRequest;
import com.srs.application.dto.response.LoginResponse;

public interface AuthenticationService {
    LoginResponse authenticate(final LoginRequest loginRequest);
}
