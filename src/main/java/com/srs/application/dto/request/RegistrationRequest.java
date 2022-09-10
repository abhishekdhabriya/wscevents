package com.srs.application.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.srs.application.constant.AppConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public final class RegistrationRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotBlank(message = "firstname should not be blank")
    private String firstname;

    @NotBlank(message = "lastname should not be blank")
    private String lastname;

    @Email(message = "email should be in email format")
    @NotBlank(message = "email should not be blank")
    private String email;

    @Size(message = "phone should be in a phone number format", min = 8, max = 12)
    private String phone;

    @JsonFormat(pattern = AppConstants.LOCAL_DATE_FORMAT, shape = JsonFormat.Shape.STRING)
    @DateTimeFormat(pattern = AppConstants.LOCAL_DATE_FORMAT)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate birthdate;

    @NotBlank(message = "username should not be blank")
    private String username;

    @NotBlank(message = "password should not be blank")
    private String password;

    @NotBlank(message = "confirm password should not be blank")
    private String confirmPassword;

    @NotBlank(message = "role should not be blank")
    private String role;
}
