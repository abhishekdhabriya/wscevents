package com.srs.application.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.srs.application.constant.AppConstant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "customers")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class Customer extends AbstractMappedEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank(message= "firstname should not be blank")
    @Column(nullable = false)
    private String firstname;

    @NotBlank(message = "lastname should not be blank")
    @Column(nullable = false)
    private String lastname;

    @Email(message = "email should be in the email format")
    @NotBlank(message = "Email should not be blank")
    @Column(nullable = false)
    private String email;

    @Size(min=8, max=12)
    @Column(precision = 8, nullable = true)
    private String phone;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="person_image_id", referencedColumnName = "id")
    private PersonImage personImage;

    @DateTimeFormat(pattern = AppConstant.LOCAL_DATE_FORMAT)
    @JsonFormat(pattern = AppConstant.LOCAL_DATE_FORMAT, shape = JsonFormat.Shape.STRING)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using= LocalDateDeserializer.class)
    private LocalDate birthdate;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="credential_id", referencedColumnName = "id", nullable = false)
    private Credential credential;


}
