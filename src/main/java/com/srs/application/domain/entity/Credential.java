package com.srs.application.domain.entity;

import com.srs.application.domain.enums.UserRoleBasedAuthority;
import com.srs.application.domain.listener.CredentialEntityListener;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "credentials")
@EntityListeners(CredentialEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class Credential extends AbstractMappedEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name="role", nullable = false)
    private UserRoleBasedAuthority userRoleBasedAuthority;

    @Column(name="is_enabled", nullable = false)
    private Boolean isEnabled;

    @Column(name="is_account_non_expired", nullable = false)
    private Boolean isAccountNonExpired;

    @Column(name="is_account_non_locked", nullable = false)
    private Boolean isAccountNonLocked;

    @Column(name="is_credentials_non_expired", nullable = false)
    private Boolean isCredentialsNonExpired;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "credential", optional = false)
    private Customer customer;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "credential", optional = false)
    private Employee employee;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "credential")
    private Set<VerificationToken> verificationTokens;
}
