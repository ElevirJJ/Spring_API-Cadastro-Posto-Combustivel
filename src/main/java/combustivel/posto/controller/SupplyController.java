package combustivel.posto.controller;

import combustivel.posto.domain.dto.SupplyDTO;
import combustivel.posto.domain.entity.Supply;
import combustivel.posto.domain.service.SupplyService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supply")
public class SupplyController {

    private final SupplyService supplyService;

    public SupplyController(SupplyService supplyService) {
        this.supplyService = supplyService;
    }

    @PostMapping
    public ResponseEntity<Void> post (@Valid @RequestBody SupplyDTO dto){
        supplyService.create(dto.fuelPumpID(), dto.litragem());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<SupplyDTO> getAll (Pageable pageable){
        return supplyService.listar(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SupplyDTO getID (@PathVariable Long id){
        var supplyID = supplyService.buscarID(id);

        return new SupplyDTO(supplyID.getLitragem(), supplyID.getFuelPump().getId());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        supplyService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> put (@PathVariable Long id ,@RequestBody SupplyDTO dto){
        supplyService.update(id, dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }
}
