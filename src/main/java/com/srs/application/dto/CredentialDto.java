package com.srs.application.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.srs.application.domain.enums.UserRoleBasedAuthority;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public final class CredentialDto extends AbstractMappedDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank(message = "username should be unique and not blank")
    private String username;

    @JsonIgnore
    @NotEmpty(message = "password should not be empty")
    private String password;

    @JsonProperty("role")
    @NotNull(message = "role should not be null")
    private UserRoleBasedAuthority userRoleBasedAuthority;
    private Boolean isEnabled;
    private Boolean isAccountNonExpired;
    private Boolean isAccountNonLocked;
    private Boolean isCredentialsNonExpired;
}
