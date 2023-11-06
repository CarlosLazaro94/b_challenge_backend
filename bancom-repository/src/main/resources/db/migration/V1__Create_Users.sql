CREATE TABLE users (
    id INT AUTO_INCREMENT NOT NULL COMMENT 'user identity',
    cellPhone VARCHAR(12) NULL COMMENT 'phone of the user',
    name VARCHAR(50) NULL COMMENT 'name of tha user',
    lastName VARCHAR(50) NULL COMMENT 'username of the user',
    password VARCHAR(200) NULL COMMENT 'password of the user',
    deleted TINYINT DEFAULT NULL COMMENT 'indicates if the record is deleted',
    createdDate DATETIME NOT NULL COMMENT 'create date time',
    createdBy VARCHAR(50) NOT NULL COMMENT 'user who created the record',
    lastModifiedDate DATETIME DEFAULT NULL COMMENT 'date time of the last modified',
    lastModifiedBy VARCHAR(50) DEFAULT NULL COMMENT 'user who last update record',
    CONSTRAINT users_userId_unique PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_unicode_ci
COMMENT='User master';