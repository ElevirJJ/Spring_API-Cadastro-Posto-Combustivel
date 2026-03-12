CREATE TABLE fuel_pumps(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome_da_bomba VARCHAR(50) NOT NULL,
    fuelTypes_id BIGINT NOT NULL,
    CONSTRAINT fk_fuel_pumps_fuel_types
            FOREIGN KEY (fuelTypes_id)
            REFERENCES fuel_types(id)

)