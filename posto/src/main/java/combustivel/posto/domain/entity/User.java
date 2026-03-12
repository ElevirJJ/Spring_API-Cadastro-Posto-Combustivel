package combustivel.posto.domain.entity;

import combustivel.posto.domain.dto.UserDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Table(name = "user_tb")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String senha;


    public boolean isLogin(UserDTO userDTO, PasswordEncoder passwordEncoder) {
        return passwordEncoder.matches(userDTO.senha(), this.senha);
    }
}
