package combustivel.posto.domain.entity;

import combustivel.posto.domain.dto.LoginDTO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Table(name = "usuario")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String senha;

    public boolean isLoginCorret(LoginDTO dto, PasswordEncoder passwordEncoder) {
       return passwordEncoder.matches(dto.senha(), this.senha);
    }
}
