package com.srs.application.service.impl;

import com.srs.application.dto.UserDetailsImplDto;
import com.srs.application.service.CredentialService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@Slf4j
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private final CredentialService credentialService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final UserDetails userDetails = new UserDetailsImplDto(this.credentialService.findByUsername(username.strip()));
        return userDetails;
    }




}
