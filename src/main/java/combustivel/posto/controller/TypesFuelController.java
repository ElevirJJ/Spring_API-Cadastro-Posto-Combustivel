package combustivel.posto.controller;

import combustivel.posto.domain.dto.TypesFuelDTO;
import combustivel.posto.domain.entity.TypesFuel;
import combustivel.posto.domain.service.TypesFuelService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/typesFuel")
public class TypesFuelController {

    private final TypesFuelService typesFuelService;

    public TypesFuelController(TypesFuelService typesFuelService) {
        this.typesFuelService = typesFuelService;
    }

    @PostMapping
    public ResponseEntity<Void> post (@Valid @RequestBody TypesFuelDTO dto){
        typesFuelService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public Page<TypesFuelDTO> get (Pageable pageable){
       return typesFuelService.listar(pageable);
    }

    @GetMapping("/{id}")
    public TypesFuelDTO getID (@PathVariable Long id){
        var typesFuel = typesFuelService.buscarID(id);

        return new TypesFuelDTO(typesFuel.getNome(), typesFuel.getPrecoPorLitro());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable Long id){
        typesFuelService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> put (@PathVariable Long id, @RequestBody TypesFuelDTO dto){
       typesFuelService.update(id, dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

}
