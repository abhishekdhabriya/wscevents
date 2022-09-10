package com.srs.application.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.srs.application.constant.AppConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name="employees")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class Employee extends AbstractMappedEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Email(message = "Email should be in email format")
    @Column(nullable = false)
    private String email;

    @Size(message = "Phone must be in phone format")
    @Column(precision = 8, nullable = true)
    private String phone;

    @JsonFormat(pattern = AppConstants.LOCAL_DATE_FORMAT, shape=JsonFormat.Shape.STRING)
    @DateTimeFormat(pattern = AppConstants.LOCAL_DATE_FORMAT)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate birthdate;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="user_image_id", referencedColumnName = "id")
    private PersonImage personImage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manger_id", referencedColumnName = "id", nullable = true)
    private Employee manager;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "manager")
    private Set<Employee> workers;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "credential_id", referencedColumnName = "id", nullable = true)
    private Credential credential;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "employee")
    private Set<Rating> ratings;
}
