CREATE TABLE cidade
(
    id        BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome      VARCHAR(255) NOT NULL,
    estado_id BIGINT       NOT NULL,
    FOREIGN KEY (estado_id) REFERENCES estado (id)
) engine = InnoDB
  DEFAULT CHARSET = UTF8;
