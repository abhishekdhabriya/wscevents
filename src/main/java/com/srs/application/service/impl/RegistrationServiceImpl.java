package com.srs.application.service.impl;

import com.srs.application.dto.request.RegistrationRequest;
import com.srs.application.dto.response.RegisterResponse;
import com.srs.application.mapper.CustomerMapper;
import com.srs.application.repository.CustomerRepository;
import com.srs.application.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private final CustomerRepository customerRepository;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Override
    public RegisterResponse register(final RegistrationRequest registrationRequest) {
        registrationRequest.setPassword(this.passwordEncoder.encode(registrationRequest.getPassword()));
        final var savedCustomer = this.customerRepository.save(CustomerMapper.map(registrationRequest));
        return new RegisterResponse(savedCustomer.getFirstname() + "created successfully");
    }
}
