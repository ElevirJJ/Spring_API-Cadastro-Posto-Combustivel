package combustivel.posto.controller;

import combustivel.posto.domain.dto.FuelTypesDTO;
import combustivel.posto.domain.entity.FuelTypes;
import combustivel.posto.domain.service.FuelTypesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fueltypes")
public class FueltypesController {


    private final FuelTypesService fuelTypesService;

    public FueltypesController(FuelTypesService fuelTypesService) {
        this.fuelTypesService = fuelTypesService;
    }

    @PostMapping
    public ResponseEntity<Void> post (@RequestBody FuelTypesDTO fuelTypesDTO){
        fuelTypesService.newFuelTypes(fuelTypesDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity <List<FuelTypes>> getList (){
        var listGet = fuelTypesService.list();
        return ResponseEntity.ok(listGet);
    }

    @GetMapping("/{id}")
    public ResponseEntity getID (@PathVariable Long id){
        return ResponseEntity.ok(fuelTypesService.searchByID(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteID (@PathVariable Long id){
        fuelTypesService.deleteByID(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> put (@PathVariable Long id, @RequestBody FuelTypesDTO fuelTypesDTO){
        fuelTypesService.update(id, fuelTypesDTO);
        return ResponseEntity.ok().build();
    }
}
