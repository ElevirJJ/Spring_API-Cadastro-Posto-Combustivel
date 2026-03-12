package combustivel.posto.domain.dto;

import java.math.BigDecimal;

public record FuelTypesDTO(Long id, String nome, BigDecimal precoPorLitro) {
}
