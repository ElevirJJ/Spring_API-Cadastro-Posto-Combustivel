CREATE TABLE supply (
    id BIGINT NOT NULL AUTO_INCREMENT,
    data_abastecimento DATE NOT NULL,
    quantidade_valores DECIMAL (10,2) NOT NULL,
    litragem BIGINT NOT NULL,
    ativo TINYINT (1) NOT NULL DEFAULT (1),
    fuelPump_id BIGINT,
    PRIMARY KEY(id),
    FOREIGN KEY (fuelPump_id) REFERENCES fuelPump(id) ON DELETE CASCADE

);