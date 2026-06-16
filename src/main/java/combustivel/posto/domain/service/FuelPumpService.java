package combustivel.posto.domain.service;

import combustivel.posto.domain.dto.FuelPumpDTO;
import combustivel.posto.domain.entity.FuelPump;
import combustivel.posto.domain.entity.TypesFuel;
import combustivel.posto.exception.NotFoundException;
import combustivel.posto.repository.FuelPumpRepository;
import combustivel.posto.repository.TypesFuelRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuelPumpService {

    private final FuelPumpRepository repository;
    private  final TypesFuelService typesFuelService;

    public FuelPumpService(FuelPumpRepository repository, TypesFuelService typesFuelService) {
        this.repository = repository;
        this.typesFuelService = typesFuelService;
    }


    public void create (FuelPumpDTO dto) {

        if (dto.typesFuelID() == null){
            throw new NotFoundException("Escolha o tipo de combustivel");
        }



        TypesFuel typesFuel = typesFuelService.buscarID(dto.typesFuelID());

        FuelPump fuelPump = new FuelPump();
        fuelPump.setNome(dto.nome());
        fuelPump.setTypesFuel(typesFuel);

        repository.save(fuelPump);
    }

    public Page<FuelPumpDTO> list (Pageable pageable){
        return repository.findAll(pageable)
                .map(f -> new FuelPumpDTO(f.getNome(), f.getTypesFuel().getId()));

    }

    public FuelPump buscar(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("id %s não encontrado", id)));
    }

    public void delete (Long id){
        FuelPump deleteID = buscar(id);
        deleteID.setAtivo(false);
        repository.save(deleteID);

    }

    public void uptade(Long id, FuelPumpDTO dto){
        FuelPump fuelPumpEntity = buscar(id);

        fuelPumpEntity.setNome(dto.nome() != null ? dto.nome() : fuelPumpEntity.getNome());
        fuelPumpEntity.setTypesFuel(dto.typesFuelID() != null ? typesFuelService.buscarID(dto.typesFuelID()) : fuelPumpEntity.getTypesFuel());
        repository.save(fuelPumpEntity);
    }
}
