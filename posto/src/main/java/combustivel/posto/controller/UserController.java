package combustivel.posto.controller;

import combustivel.posto.domain.dto.UserDTO;
import combustivel.posto.domain.entity.User;
import combustivel.posto.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cadastro")
public class UserController {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Void> createNew(@RequestBody UserDTO userDTO){
        var newUser = userRepository.findBynome(userDTO.nome());

        if (newUser.isPresent()){
            throw new RuntimeException(" usuario ja esta cadastrado ");
        }

        User user = new User();
        user.setNome(userDTO.nome());
        user.setSenha(bCryptPasswordEncoder.encode(userDTO.senha()));
        userRepository.save(user);

        return ResponseEntity.ok().build();
    }


}