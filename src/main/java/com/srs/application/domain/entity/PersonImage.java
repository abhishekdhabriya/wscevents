package com.srs.application.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "person_images")
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class PersonImage extends AbstractMappedEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(nullable = true)
    private String name;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private Long size;

    @Lob
    @Column(name="image_lob", columnDefinition = "BLOB", nullable = true)
    private String imageLob;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "personImage")
    private Customer customer;

}
