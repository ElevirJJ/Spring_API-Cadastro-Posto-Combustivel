package combustivel.posto.controller;

import combustivel.posto.domain.dto.SupplyDTO;
import combustivel.posto.domain.entity.Supply;
import combustivel.posto.domain.service.SupplyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supply")
public class SupplyController {

    private final SupplyService supplyService;

    public SupplyController(SupplyService supplyService) {
        this.supplyService = supplyService;
    }

    @PostMapping
    public ResponseEntity<Void> post (@RequestBody SupplyDTO supplyDTO){
        supplyService.newSupply(supplyDTO.idBomba(), supplyDTO.litragem());
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity <List<Supply>> get (){
        var getList = supplyService.list();
        return ResponseEntity.ok(getList);
    }

    @GetMapping("/{id}")
    public ResponseEntity getID (@PathVariable Long id){
        return ResponseEntity.ok(supplyService.searchByID(id));
    }



}
