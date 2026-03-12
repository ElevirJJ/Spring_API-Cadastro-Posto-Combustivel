    CREATE TABLE fuel_types(
        id BIGINT AUTO_INCREMENT PRIMARY KEY,
        nome VARCHAR(50) NOT NULL,
        preco_por_litro DECIMAL(5,3) NOT NULL
    )