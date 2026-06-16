package combustivel.posto.domain.service;

import combustivel.posto.domain.dto.TypesFuelDTO;
import combustivel.posto.domain.entity.FuelPump;
import combustivel.posto.domain.entity.TypesFuel;
import combustivel.posto.exception.NotFoundException;
import combustivel.posto.repository.TypesFuelRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class TypesFuelService {

    private final TypesFuelRepository repository;


    public TypesFuelService(TypesFuelRepository repository) {
        this.repository = repository;

    }


    public void create (TypesFuelDTO dto){

        TypesFuel typesFuel = new TypesFuel();

        typesFuel.setNome(dto.nome());
        typesFuel.setPrecoPorLitro(dto.precoPorLitro());
        repository.save(typesFuel);
    }

    public Page<TypesFuelDTO> listar(Pageable pageable){
        return repository.findAll(pageable)
                .map(t-> new TypesFuelDTO(t.getNome(), t.getPrecoPorLitro()));
    }

    public TypesFuel buscarID (Long id){
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("id %s não encontrado", id)));
    }

    public void delete (Long id){
        TypesFuel deleteID = buscarID(id);
        deleteID.setAtivo(false);
        repository.save(deleteID);
    }

    public void update (Long id, TypesFuelDTO dto){
        var typesFuelEntity = buscarID(id);

        typesFuelEntity.setNome(dto.nome() != null ? dto.nome() : typesFuelEntity.getNome());
        typesFuelEntity.setPrecoPorLitro(dto.precoPorLitro() != null ? dto.precoPorLitro() : typesFuelEntity.getPrecoPorLitro());
        repository.save(typesFuelEntity);
    }
}
