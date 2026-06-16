package combustivel.posto.domain.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginDTO(@NotBlank String nome, @NotBlank String senha) {
}
