package com.srs.application.resource;

import com.srs.application.constant.AppConstants;
import com.srs.application.dto.request.RegistrationRequest;
import com.srs.application.dto.response.RegisterResponse;
import com.srs.application.dto.response.api.ApiResponse;
import com.srs.application.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(AppConstants.API_CONTEXT_V1 + "/register")
@Slf4j
@RequiredArgsConstructor
public class RegistrationResource {

    @Autowired
    private final RegistrationService registrationService;

    @PostMapping
    public ResponseEntity<ApiResponse<RegisterResponse>> register(@RequestBody @Valid final RegistrationRequest registrationRequest) {
        final var apiPayloadResponse = new ApiResponse<RegisterResponse>(1, HttpStatus.OK,true,
                this.registrationService.register(registrationRequest));
    return ResponseEntity.ok(apiPayloadResponse);
    }
}
