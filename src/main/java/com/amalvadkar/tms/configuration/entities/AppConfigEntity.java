package com.amalvadkar.tms.configuration.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "app_config")
@Getter
@Setter
public class AppConfigEntity extends AbstractBaseEntity {

    private String key;
    private String value;
    private String category;
    private String type;

}
