package combustivel.posto.controller;

import combustivel.posto.domain.dto.UserDTO;
import combustivel.posto.domain.dto.UserResponseDTO;
import combustivel.posto.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("/login")
public class TokenController {

    private final JwtEncoder jwtEncoder;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    public TokenController(JwtEncoder encoder, UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.jwtEncoder = encoder;
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> login (@RequestBody UserDTO userDTO){
       var user =  userRepository.findBynome(userDTO.nome());

       if (user.isEmpty() || !user.get().isLogin(userDTO, bCryptPasswordEncoder)){
           throw new RuntimeException(" usuario nao existir, ou a senha esta errada ");
       }

       var now = Instant.now();
       var expiration = 300L;

       var clains = JwtClaimsSet.builder()
               .issuer("myProject")
               .subject(user.get().getNome())
               .expiresAt(now.plusSeconds(expiration))
               .issuedAt(now)
               .build();

       var jwtvalue = jwtEncoder.encode(JwtEncoderParameters.from(clains)).getTokenValue();

       return ResponseEntity.ok(new UserResponseDTO(jwtvalue, expiration));
    }

}
