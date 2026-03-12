package combustivel.posto.controller;

import combustivel.posto.domain.dto.FuelPumpsDTO;
import combustivel.posto.domain.entity.FuelPumps;
import combustivel.posto.domain.service.FuelPumpsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fuelPumps")
public class FuelPumpsController {

    private final FuelPumpsService fuelPumpsService;

    public FuelPumpsController(FuelPumpsService fuelPumpsService) {
        this.fuelPumpsService = fuelPumpsService;
    }

    @PostMapping
    public ResponseEntity<Void> post (@RequestBody FuelPumpsDTO pumpsDTO){
        fuelPumpsService.newFuelPumps(pumpsDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity <List<FuelPumps>> get (){
        var listGet = fuelPumpsService.list();
        return ResponseEntity.ok(listGet);
    }

    @GetMapping("/{id}")
    public ResponseEntity getID (@PathVariable Long id){
        return ResponseEntity.ok(fuelPumpsService.searchByID(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteID (@PathVariable Long id){
        fuelPumpsService.deleteByID(id);
        return ResponseEntity.ok().build();
    }



    @PutMapping("/{id}")
    public ResponseEntity<Void> put (@PathVariable Long id, @RequestBody FuelPumpsDTO pumpsDTO){
        fuelPumpsService.uptadateFuel(id, pumpsDTO);
        return ResponseEntity.ok().build();
    }
}
