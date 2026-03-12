package combustivel.posto.repository;

import combustivel.posto.domain.entity.FuelTypes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuelTypesRepository extends JpaRepository<FuelTypes, Long> {
}
