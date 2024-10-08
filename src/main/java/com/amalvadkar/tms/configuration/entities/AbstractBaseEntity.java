package com.amalvadkar.tms.configuration.entities;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@MappedSuperclass
public class AbstractBaseEntity {

    @Id
    private Long id;
    private Boolean deleteFlag;
    private Instant createdOn;
    private Long createdBy;
    private Instant updatedOn;
    private Long updatedBy;

}
