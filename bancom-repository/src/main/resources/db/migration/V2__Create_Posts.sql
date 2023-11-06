CREATE TABLE posts (
    id INT AUTO_INCREMENT NOT NULL COMMENT 'user identity',
    text VARCHAR(50) NULL COMMENT 'text of the post',
    user_id INT NOT NULL COMMENT 'relations users',
    deleted TINYINT DEFAULT NULL COMMENT 'indicates if the record is deleted',
    createdDate DATETIME NOT NULL COMMENT 'create date time',
    createdBy VARCHAR(50) NOT NULL COMMENT 'user who created the record',
    lastModifiedDate DATETIME DEFAULT NULL COMMENT 'date time of the last modified',
    lastModifiedBy VARCHAR(50) DEFAULT NULL COMMENT 'user who last update record',
    CONSTRAINT users_userId_unique PRIMARY KEY (id),
    CONSTRAINT fk_post_users FOREIGN KEY (user_id) REFERENCES users(id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_unicode_ci
COMMENT='Posts master';