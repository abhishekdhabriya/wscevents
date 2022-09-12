package com.srs.application.service.impl;

import com.srs.application.dto.CredentialDto;
import com.srs.application.exception.wrapper.CredentialNotFoundException;
import com.srs.application.mapper.CredentialMapper;
import com.srs.application.repository.CredentialRepository;
import com.srs.application.service.CredentialService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@Slf4j
@RequiredArgsConstructor
public class CredentialServiceImpl implements CredentialService {

    @Autowired
    private final CredentialRepository credentialRepository;

    @Override
    public CredentialDto findById(final Integer id) {
        return this.credentialRepository.findById(id)
                .map(CredentialMapper::map)
                .orElseThrow(() -> new CredentialNotFoundException(String
                        .format("Credential with id %id not found", id)));
    }

    @Override
    public CredentialDto findByUsername(final String username) {
        return this.credentialRepository.findByUsername(username)
                .map(CredentialMapper::map)
                .orElseThrow(() -> new CredentialNotFoundException(String
                        .format("Credential with username %s not found", username)));
    }
}
