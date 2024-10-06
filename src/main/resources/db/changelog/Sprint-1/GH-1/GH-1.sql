-- liquibase formatted sql

--changeset Abhishek Malvadkar:1-create-app-config-table
CREATE TABLE app_config (
    id bigint auto_increment primary key,
    `key` VARCHAR(255) NOT NULL UNIQUE,
    `value` VARCHAR(1000) null,
    `category` VARCHAR(100) not null,
    `type` VARCHAR(200) not null,
    delete_flag BIT(1) NOT NULL DEFAULT 0,
    created_on DATETIME NOT NULL,
    created_by BIGINT  not null,
    updated_on DATETIME NOT NULL,
    updated_by BIGINT  not null
);


--changeset Abhishek Malvadkar:2-insert-app-configs-for-general-category
INSERT INTO app_config (`key`, `value`, `category`, `type`, created_on,updated_on,created_by, updated_by)
VALUES
('siteLogo', 'url', 'GENERAL','text', UTC_TIMESTAMP(), UTC_TIMESTAMP() , 1, 1),
('siteTagLine', 'Helps To Manage Tasks', 'GENERAL', 'text' ,UTC_TIMESTAMP(),UTC_TIMESTAMP() , 1, 1),
('productVersion', '1.0', 'GENERAL', 'decimal', UTC_TIMESTAMP(),UTC_TIMESTAMP() , 1, 1),
('preMaintenanceMsg', null, 'GENERAL', 'text', UTC_TIMESTAMP(),  UTC_TIMESTAMP() , 1, 1),
('maintenanceMsg', null, 'GENERAL', 'text', UTC_TIMESTAMP(),  UTC_TIMESTAMP() , 1, 1),
('maintenanceFrom', null, 'GENERAL', 'datetime', UTC_TIMESTAMP(),  UTC_TIMESTAMP() , 1, 1),
('maintenanceTo', null, 'GENERAL', 'datetime', UTC_TIMESTAMP(),UTC_TIMESTAMP() , 1, 1);