CREATE TABLE fuel_pump (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    ativo TINYINT (1) NOT NULL DEFAULT(1),
    typesFuel_id BIGINT,

    PRIMARY KEY (id)
    FOREIGN KEY (typesFuel_id) REFERENCES types_fuel(id) ON DELETE CASCADE

);