package com.srs.application.mapper;

import com.srs.application.domain.entity.Credential;
import com.srs.application.dto.CredentialDto;


import javax.validation.constraints.NotNull;

public interface CredentialMapper {

    public static CredentialDto map(@NotNull final Credential credential) {
        return CredentialDto.builder()
                .id(credential.getId())
                .username(credential.getUsername())
                .password(credential.getPassword())
                .userRoleBasedAuthority(credential.getUserRoleBasedAuthority())
                .isEnabled(credential.getIsEnabled())
                .isAccountNonExpired(credential.getIsAccountNonExpired())
                .isAccountNonLocked(credential.getIsAccountNonLocked())
                .isCredentialsNonExpired(credential.getIsCredentialsNonExpired())
                .build();
    }

    public static Credential map(@NotNull final CredentialDto credentialDto) {
        return Credential.builder()
                .id(credentialDto.getId())
                .username(credentialDto.getUsername())
                .password(credentialDto.getPassword())
                .userRoleBasedAuthority(credentialDto.getUserRoleBasedAuthority())
                .isEnabled(credentialDto.getIsEnabled())
                .isAccountNonLocked(credentialDto.getIsAccountNonLocked())
                .isAccountNonExpired(credentialDto.getIsAccountNonExpired())
                .isCredentialsNonExpired(credentialDto.getIsCredentialsNonExpired())
                .build();
    }
}
