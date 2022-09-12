package com.srs.application.domain.listener;

import com.srs.application.domain.entity.Credential;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.PrePersist;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CredentialEntityListener {

    @PrePersist
    public void preCreate(final Credential credential) {
        credential.setIsEnabled(true);
        credential.setIsCredentialsNonExpired(true);
        credential.setIsAccountNonLocked(true);
        credential.setIsAccountNonExpired(true);
    }

}
