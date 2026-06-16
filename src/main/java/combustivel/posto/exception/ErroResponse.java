package combustivel.posto.exception;

import lombok.Builder;

@Builder
public record ErroResponse(String messagem, Integer status) {
}
