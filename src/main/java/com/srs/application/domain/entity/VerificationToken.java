package com.srs.application.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.srs.application.constant.AppConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name="verification_tokens")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class VerificationToken  extends AbstractMappedEntity implements Serializable {
    private static final long serialVersionUID = 1l;

    @Column(unique = true, nullable = false)
    private String token;

    @Column(name="expire_date")
    @JsonFormat(pattern = AppConstants.LOCAL_DATE_TIME_FORMAT, shape= JsonFormat.Shape.STRING)
    @DateTimeFormat(pattern= AppConstants.LOCAL_DATE_FORMAT)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using= LocalDateTimeDeserializer.class)
    private LocalDateTime expireData;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="credential_id", referencedColumnName = "id")
    private Credential credential;
}
