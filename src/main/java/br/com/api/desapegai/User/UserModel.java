package br.com.api.desapegai.User;

import java.util.List;
import br.com.api.desapegai.Ad.AdModel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password; // A senha deve ser armazenada de forma segura (não como texto simples)
    private String address;
    private String phone;

    @OneToMany(mappedBy = "seller")
    private List<AdModel> ads; // Anúncios publicados pelo usuário
}
