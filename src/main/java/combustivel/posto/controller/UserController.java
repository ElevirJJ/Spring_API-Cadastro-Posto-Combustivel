package combustivel.posto.controller;

import combustivel.posto.domain.dto.LoginDTO;
import combustivel.posto.domain.entity.Usuario;
import combustivel.posto.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(UsuarioRepository usuarioRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping
    public ResponseEntity<Void> newUser (@Valid @RequestBody LoginDTO dto){
        var user = usuarioRepository.findByNome(dto.nome());

        if (user.isPresent()){
            throw new RuntimeException("Usuario já está cadastrado");
        }

        var newUsuarios = new Usuario();
        newUsuarios.setNome(dto.nome());
        newUsuarios.setSenha(bCryptPasswordEncoder.encode(dto.senha()));
        usuarioRepository.save(newUsuarios);
        return ResponseEntity.ok().build();
    }
}
