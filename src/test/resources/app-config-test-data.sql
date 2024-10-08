delete from app_config;

INSERT INTO app_config (`key`, `value`, `category`, `type`, created_on,updated_on,created_by, updated_by)
VALUES
('siteLogo', 'url', 'GENERAL','text', UTC_TIMESTAMP(), UTC_TIMESTAMP() , 1, 1),
('siteTagLine', 'Helps To Manage Tasks', 'GENERAL', 'text' ,UTC_TIMESTAMP(),UTC_TIMESTAMP() , 1, 1);