package combustivel.posto.domain.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Table(name = "fuel_pumps")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FuelPumps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome_da_bomba")
    private String nomeDaBomba;
    @ManyToOne
    @JoinColumn(name = "fuelTypes_id")
    private FuelTypes fuelTypes;


}
