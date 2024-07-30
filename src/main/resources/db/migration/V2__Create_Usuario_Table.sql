CREATE TABLE usuario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    telefone VARCHAR(255),
    endereco VARCHAR(255),
    status BOOLEAN
);
