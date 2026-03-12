package combustivel.posto.domain.service;

import combustivel.posto.domain.dto.SupplyDTO;
import combustivel.posto.domain.entity.FuelPumps;
import combustivel.posto.domain.entity.Supply;
import combustivel.posto.repository.SupplyRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class SupplyService {

    private final SupplyRepository supplyRepository;
    private final FuelPumpsService fuelPumpsService;

    public SupplyService(SupplyRepository supplyRepository, FuelPumpsService fuelPumpsService) {
        this.supplyRepository = supplyRepository;
        this.fuelPumpsService = fuelPumpsService;
    }

    public void newSupply (Long id, Long litros ){

        FuelPumps pumps = fuelPumpsService.searchByID(id);
        BigDecimal valueTotal = pumps.getFuelTypes().getPrecoPorLitro().multiply(BigDecimal.valueOf(litros));

        Supply supply = Supply.builder()
                .dataDoAbastecimento(LocalDate.now())
                .fuelPumps(pumps)
                .quantidadeEmValores(valueTotal)
                .litragem(litros)
                .build();

        supplyRepository.save(supply);


    }

    public List<Supply> list (){
        return supplyRepository.findAll();
    }

    public Supply searchByID (Long id){
        return supplyRepository.findById(id)
                .orElseThrow(()-> new RuntimeException(id + " nao existir no banco "));
    }


}
