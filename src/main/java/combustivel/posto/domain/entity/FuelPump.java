package combustivel.posto.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "fuel_pump")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FuelPump {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private  Boolean ativo = true;

    @ManyToOne
    @JoinColumn(name = "typesFuel_id")
    private TypesFuel typesFuel;

}
