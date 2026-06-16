package combustivel.posto.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record TypesFuelDTO(@NotBlank String nome, @NotNull BigDecimal precoPorLitro) {
}
