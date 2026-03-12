package combustivel.posto.domain.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import combustivel.posto.domain.entity.FuelTypes;


public record FuelPumpsDTO(String nome, @JsonProperty("tipos_compustivel") FuelTypes fuelTypes) {
}
