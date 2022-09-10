package com.srs.application.service;

import com.srs.application.dto.request.RegistrationRequest;
import com.srs.application.dto.response.RegisterResponse;

public interface RegistrationService {

    RegisterResponse register (final RegistrationRequest registrationRequest);
}
