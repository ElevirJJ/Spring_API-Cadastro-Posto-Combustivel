package combustivel.posto.domain.service;

import combustivel.posto.domain.dto.FuelTypesDTO;
import combustivel.posto.domain.entity.FuelTypes;
import combustivel.posto.repository.FuelTypesRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuelTypesService {

    private final FuelTypesRepository fuelTypesRepository;

    public FuelTypesService(FuelTypesRepository fuelTypesRepository) {
        this.fuelTypesRepository = fuelTypesRepository;
    }

    public void newFuelTypes(FuelTypesDTO fuelTypesDTO){
        FuelTypes createFuelTypes = new FuelTypes();
        createFuelTypes.setNome(fuelTypesDTO.nome());
        createFuelTypes.setPrecoPorLitro(fuelTypesDTO.precoPorLitro());
        fuelTypesRepository.save(createFuelTypes);
    }

    public List<FuelTypes> list (){
        return fuelTypesRepository.findAll();
    }

    public FuelTypes searchByID (Long id){
        return fuelTypesRepository.findById(id)
                .orElseThrow(()-> new RuntimeException(id + " nao existir "));
    }

    @Transactional
    public void deleteByID (Long id){
        if (fuelTypesRepository.existsById(id)){
            fuelTypesRepository.deleteById(id);
        }else {
            throw new RuntimeException(id + " nao existir ");
        }
    }

    public void update (Long id, FuelTypesDTO dto){
        FuelTypes typesEntity = searchByID(id);

        typesEntity.setNome(dto.nome() != null ? dto.nome() : typesEntity.getNome());
        typesEntity.setPrecoPorLitro(dto.precoPorLitro() != null ? dto.precoPorLitro() : typesEntity.getPrecoPorLitro());
        fuelTypesRepository.save(typesEntity);

    }

}
