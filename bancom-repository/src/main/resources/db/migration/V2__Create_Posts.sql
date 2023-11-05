CREATE TABLE posts (
    id INT AUTO_INCREMENT NOT NULL COMMENT 'user identity',
    text VARCHAR(50) NULL COMMENT 'text of the post',
    deleted TINYINT DEFAULT NULL COMMENT 'indicates if the record is deleted',
    createDate DATETIME NOT NULL COMMENT 'create date time',
    createBy VARCHAR(50) NOT NULL COMMENT 'user who created the record',
    lastModifiedDate DATETIME DEFAULT NULL COMMENT 'date time of the last modified',
    lastModifiedBy VARCHAR(50) DEFAULT NULL COMMENT 'user who last update record',
    CONSTRAINT users_userId_unique PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_unicode_ci
COMMENT='Posts master';