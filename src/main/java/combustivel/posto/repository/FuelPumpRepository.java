package combustivel.posto.repository;

import combustivel.posto.domain.entity.FuelPump;
import combustivel.posto.domain.entity.TypesFuel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuelPumpRepository extends JpaRepository<FuelPump, Long> {



}