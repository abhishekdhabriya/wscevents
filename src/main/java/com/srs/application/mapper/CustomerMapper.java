package com.srs.application.mapper;

import com.srs.application.domain.entity.Credential;
import com.srs.application.domain.entity.Customer;
import com.srs.application.domain.enums.UserRoleBasedAuthority;
import com.srs.application.dto.CredentialDto;
import com.srs.application.dto.CustomerDto;
import com.srs.application.dto.request.RegistrationRequest;

import javax.validation.constraints.NotNull;
import java.time.Instant;

public interface CustomerMapper {
    static CustomerDto map(@NotNull final Customer customer) {

        return CustomerDto.builder()
                .id(customer.getId())
                .firstname(customer.getFirstname())
                .lastname(customer.getLastname())
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .birthdate(customer.getBirthdate())
                .credentialDto(
                        CredentialDto.builder()
                                .id(customer.getCredential().getId())
                                .username(customer.getCredential().getUsername())
                                .userRoleBasedAuthority(customer.getCredential().getUserRoleBasedAuthority())
                                .isEnabled(customer.getCredential().getIsEnabled())
                                .isAccountNonLocked(customer.getCredential().getIsAccountNonLocked())
                                .isCredentialsNonExpired(customer.getCredential().getIsCredentialsNonExpired())
                                .build()
                ).build();

    }

    static Customer map(final RegistrationRequest registrationRequest) {
        return Customer.builder()
                .firstname(registrationRequest.getFirstname())
                .lastname(registrationRequest.getLastname())
                .email(registrationRequest.getEmail())
                .phone(registrationRequest.getPhone())
                .birthdate(registrationRequest.getBirthdate())
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .credential(
                        Credential.builder()
                                .username(registrationRequest.getUsername())
                                .password(registrationRequest.getPassword())
                                .userRoleBasedAuthority(UserRoleBasedAuthority.toEnum(registrationRequest.getRole()))
                                .createdAt(Instant.now())
                                .updatedAt(Instant.now())
                                .build()
                ).build();
    }



}
