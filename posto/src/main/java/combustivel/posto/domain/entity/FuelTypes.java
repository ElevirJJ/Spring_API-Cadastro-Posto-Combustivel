package combustivel.posto.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "fuel_types")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FuelTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(name = "preco_por_litro")
    private BigDecimal precoPorLitro;
}
