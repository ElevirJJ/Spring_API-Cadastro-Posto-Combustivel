package combustivel.posto.repository;

import combustivel.posto.domain.entity.TypesFuel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TypesFuelRepository extends JpaRepository<TypesFuel, Long> {


}
