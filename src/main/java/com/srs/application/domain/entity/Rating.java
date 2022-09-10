package com.srs.application.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.srs.application.constant.AppConstants;
import com.srs.application.domain.enums.UserRating;
import com.srs.application.domain.id.RatingId;
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
@Table(name = "ratings")
@IdClass(RatingId.class)
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class Rating extends AbstractAuditingMappedEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "employee_id", nullable = false, insertable = false, updatable = false)
    private Integer employeeId;

    @Id
    @Column(name = "customer_id", nullable = false, insertable = false, updatable = false)
    private Integer customerId;

    @Id
    @Column(name="rate_date", nullable = false, insertable = false, updatable = false)
    @JsonFormat(pattern = AppConstants.LOCAL_DATE_TIME_FORMAT, shape= JsonFormat.Shape.STRING)
    @DateTimeFormat(pattern = AppConstants.LOCAL_DATE_TIME_FORMAT)
    @JsonSerialize(using= LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime rateDate;

    @Enumerated(EnumType.STRING)
    @Column(name="rate", nullable = false)
    private UserRating rate;

    @Column(nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", referencedColumnName = "id", nullable = false, updatable = false)
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false, updatable = false)
    private Customer customer;

}
