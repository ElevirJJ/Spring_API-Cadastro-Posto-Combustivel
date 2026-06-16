package combustivel.posto.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "types_fuel")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TypesFuel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private BigDecimal precoPorLitro;
    private Boolean ativo = true;
}
