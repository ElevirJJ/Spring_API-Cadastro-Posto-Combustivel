package combustivel.posto.controller;

import combustivel.posto.domain.dto.LoginDTO;
import combustivel.posto.domain.dto.LoginResponse;
import combustivel.posto.repository.UsuarioRepository;
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
    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public TokenController(JwtEncoder encoder, UsuarioRepository usuarioRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.jwtEncoder = encoder;
        this.usuarioRepository = usuarioRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping
    public ResponseEntity<LoginResponse> login (@RequestBody LoginDTO dto){
      var user = usuarioRepository.findByNome(dto.nome());

      if (user.isEmpty() || !user.get().isLoginCorret(dto, bCryptPasswordEncoder)){
          throw new RuntimeException("usuario ou senha não existir");
      }

      var now = Instant.now();
      var expiracao = 800L;

      var clains = JwtClaimsSet.builder()
              .issuer("myback")
              .subject(user.get().getId().toString())
              .expiresAt(now.plusSeconds(expiracao))
              .issuedAt(now)
              .build();


      var jwtvalue = jwtEncoder.encode(JwtEncoderParameters.from(clains)).getTokenValue();
      return ResponseEntity.ok(new LoginResponse(jwtvalue, expiracao));

    }
}
