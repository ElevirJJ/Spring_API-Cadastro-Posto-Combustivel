package combustivel.posto.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "supply")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Supply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataAbastecimento;
    private BigDecimal quantidadeValores;
    private Long litragem;
    @Builder.Default
    private Boolean ativo = true;

    @ManyToOne
    @JoinColumn(name = "fuelPump_id")
    private FuelPump fuelPump;


}
