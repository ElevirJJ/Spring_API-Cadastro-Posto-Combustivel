package combustivel.posto.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "supply")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Supply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "data_do_abastecimento")
    private LocalDate dataDoAbastecimento;
    @Column(name = "quantidade_em_valores")
    private BigDecimal quantidadeEmValores;
    private Long litragem;
    @ManyToOne
    @JoinColumn(name = "fuelPumps_id")
    private FuelPumps fuelPumps;

}
