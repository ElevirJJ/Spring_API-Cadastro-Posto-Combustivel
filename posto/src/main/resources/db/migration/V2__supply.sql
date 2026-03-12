CREATE TABLE supply(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    data_do_abastecimento DATE NOT NULL,
    quantidade_em_valores DECIMAL (10,5) NOT NULL,
    litragem BIGINT,
    fuelPumps_id BIGINT,

      CONSTRAINT fk_supply_fuel_pumps
            FOREIGN KEY (fuelPumps_id)
            REFERENCES fuel_pumps(id)

)