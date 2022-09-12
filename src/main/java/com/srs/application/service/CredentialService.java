package com.srs.application.service;

import com.srs.application.dto.CredentialDto;

public interface CredentialService {
    CredentialDto findById(final Integer id);
    CredentialDto findByUsername(final String username);
}
