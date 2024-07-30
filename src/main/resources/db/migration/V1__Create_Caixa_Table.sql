CREATE TABLE caixa (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(255) NOT NULL,
    tipo VARCHAR(255) NOT NULL,
    cliente VARCHAR(255),
    valor DECIMAL(10, 2),
    numero_nota INT
);
