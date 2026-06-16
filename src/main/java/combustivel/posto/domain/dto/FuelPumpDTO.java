package combustivel.posto.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FuelPumpDTO(@NotBlank String nome, @NotNull @JsonProperty("tiposCombustivel") Long typesFuelID) {
}
