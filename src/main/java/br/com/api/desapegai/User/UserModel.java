package br.com.api.desapegai.User;
import java.util.List;
import br.com.api.desapegai.Ad.AdModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users") // Especifica o nome da tabela para UserModel
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String password; // A senha deve ser armazenada de forma segura (não como texto simples)
    private String address;
    private String phone;

    @OneToMany(mappedBy = "seller")
    private List<AdModel> ads; // Anúncios publicados pelo usuário
}
