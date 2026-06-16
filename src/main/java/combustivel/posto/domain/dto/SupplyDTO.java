package combustivel.posto.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;


public record SupplyDTO (@NotNull Long litragem, @NotNull @JsonProperty("bombaCombustivel") Long fuelPumpID) {
}
