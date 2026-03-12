package combustivel.posto.domain.service;

import combustivel.posto.domain.dto.FuelPumpsDTO;
import combustivel.posto.domain.entity.FuelPumps;
import combustivel.posto.domain.entity.FuelTypes;
import combustivel.posto.repository.FuelPumpsRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuelPumpsService {

    private final FuelPumpsRepository fuelPumpsRepository;
    private final FuelTypesService fuelTypesService;

    public FuelPumpsService(FuelPumpsRepository fuelPumpsRepository, FuelTypesService fuelTypesService) {
        this.fuelPumpsRepository = fuelPumpsRepository;
        this.fuelTypesService = fuelTypesService;
    }

    public void newFuelPumps (FuelPumpsDTO dto){

        FuelTypes fuelTypes = fuelTypesService.searchByID(dto.fuelTypes().getId());

        FuelPumps CreateFuelPumps = new FuelPumps();
        CreateFuelPumps.setNomeDaBomba(dto.nome());
        CreateFuelPumps.setFuelTypes(fuelTypes);
        fuelPumpsRepository.save(CreateFuelPumps);
    }

    public List<FuelPumps> list(){
        return fuelPumpsRepository.findAll();
    }

    public FuelPumps searchByID (Long id){
        return fuelPumpsRepository.findById(id)
                .orElseThrow(()-> new RuntimeException(id + " nao existir no banco de dados "));
    }


    @Transactional
    public void deleteByID (Long id){
        if (fuelPumpsRepository.existsById(id)){
            fuelPumpsRepository.deleteById(id);
        }else {
            throw new RuntimeException(id + " nao existir ");
        }
    }

    public void uptadateFuel (Long id, FuelPumpsDTO dto){
        FuelPumps pumpsEntity = searchByID(id);

        pumpsEntity.setNomeDaBomba(dto.nome() != null ? dto.nome() : pumpsEntity.getNomeDaBomba());
        pumpsEntity.setFuelTypes(fuelTypesService.searchByID(dto.fuelTypes().getId()));
        fuelPumpsRepository.save(pumpsEntity);
    }

}
