package combustivel.posto.domain.service;

import combustivel.posto.domain.dto.SupplyDTO;
import combustivel.posto.domain.entity.FuelPump;
import combustivel.posto.domain.entity.Supply;
import combustivel.posto.exception.NotFoundException;
import combustivel.posto.repository.SupplyRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class SupplyService {

    public final FuelPumpService fuelPumpService;
    public final SupplyRepository repository;


    public SupplyService(FuelPumpService fuelPumpService, SupplyRepository repository) {
        this.fuelPumpService = fuelPumpService;
        this.repository = repository;
    }

    public void create(Long id, Long litros){
        FuelPump fuelPump = fuelPumpService.buscar(id);

        BigDecimal quantidadeLitros = fuelPump.getTypesFuel().getPrecoPorLitro().multiply(BigDecimal.valueOf(litros));

        Supply supply = Supply.builder()
                .dataAbastecimento(LocalDate.now())
                .litragem(litros)
                .fuelPump(fuelPump)
                .quantidadeValores(quantidadeLitros)
                .build();

        repository.save(supply);
    }

    public Page<SupplyDTO> listar (Pageable pageable){
        return repository.findAll(pageable)
                .map(s -> new SupplyDTO(s.getLitragem(), s.getFuelPump().getId()));

    }

    public Supply buscarID (Long id){
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("id %s não encontrado", id)));
    }

    public void delete (Long id){
        Supply deleteID = buscarID(id);
        deleteID.setAtivo(false);
        repository.save(deleteID);
    }

    public void update (Long id, SupplyDTO dto ){
        Supply supplyEntity = buscarID(id);

        supplyEntity.setLitragem(dto.litragem() != null ? dto.litragem() : supplyEntity.getLitragem());
        supplyEntity.setFuelPump(dto.fuelPumpID() != null ? fuelPumpService.buscar(dto.fuelPumpID()) : supplyEntity.getFuelPump());
        repository.save(supplyEntity);
    }


}
