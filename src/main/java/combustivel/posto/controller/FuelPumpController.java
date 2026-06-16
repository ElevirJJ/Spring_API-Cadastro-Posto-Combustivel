package combustivel.posto.controller;


import combustivel.posto.domain.dto.FuelPumpDTO;
import combustivel.posto.domain.service.FuelPumpService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fuelPump")
public class FuelPumpController {

    private final FuelPumpService fuelPumpService;

    public FuelPumpController(FuelPumpService fuelPumpService) {
        this.fuelPumpService = fuelPumpService;
    }

    @PostMapping
    public ResponseEntity<Void> post  (@Valid @RequestBody FuelPumpDTO dto){
        fuelPumpService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @GetMapping
    public Page<FuelPumpDTO> getAll (Pageable pageable){
       return fuelPumpService.list(pageable);

    }

    @GetMapping("/{id}")
    public FuelPumpDTO getID (@PathVariable Long id){
        var getByID = fuelPumpService.buscar(id);

        return new FuelPumpDTO(getByID.getNome(), getByID.getTypesFuel().getId());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        fuelPumpService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> put (@PathVariable Long id, @RequestBody FuelPumpDTO dto){
        fuelPumpService.uptade(id, dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
