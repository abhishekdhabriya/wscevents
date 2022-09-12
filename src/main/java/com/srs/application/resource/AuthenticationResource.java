package com.srs.application.resource;

import com.srs.application.constant.AppConstants;
import com.srs.application.dto.request.LoginRequest;
import com.srs.application.dto.response.LoginResponse;
import com.srs.application.dto.response.api.ApiResponse;
import com.srs.application.service.AuthenticationService;
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
@RequestMapping(AppConstants.API_CONTEXT_V1 + "/authenticate")
@Slf4j
@RequiredArgsConstructor
public class AuthenticationResource {

    @Autowired
    private final AuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<ApiResponse<LoginResponse>> authenticate(@RequestBody @Valid final LoginRequest loginRequest) {
        final var apiPayloadResponse = new ApiResponse<>(1, HttpStatus.OK, true,
                this.authenticationService.authenticate(loginRequest));
        return ResponseEntity.status(HttpStatus.OK)
                .body(apiPayloadResponse);
    }
}
