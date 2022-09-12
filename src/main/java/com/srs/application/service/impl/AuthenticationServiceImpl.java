package com.srs.application.service.impl;

import com.srs.application.dto.request.LoginRequest;
import com.srs.application.dto.response.LoginResponse;
import com.srs.application.exception.wrapper.AppBadCredentialsException;
import com.srs.application.security.JwtManager;
import com.srs.application.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
@Slf4j
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private final AuthenticationManager authenticationManager;

    @Autowired
    private final UserDetailsService userDetailsService;

    @Autowired
    private final JwtManager jwtManager;



    @Override
    public LoginResponse authenticate(final LoginRequest loginRequest) {
        try {
            this.authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
            );
        } catch(BadCredentialsException e) {
            throw new AppBadCredentialsException("Bad credentials");
        }

        final var userDetails = this.userDetailsService.loadUserByUsername(loginRequest.getUsername().toLowerCase());
        return new LoginResponse(userDetails.getUsername(), this.jwtManager.generateToken(userDetails));

    }
}
