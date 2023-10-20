package br.com.api.desapegai.Comment; // Correção para CommentModel
import java.util.Date;

import br.com.api.desapegai.Ad.AdModel;
import br.com.api.desapegai.User.UserModel; // Correção para User
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CommentModel { // Correção para CommentModel
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private Date creationDate;

    @ManyToOne
    private UserModel user; // Correção para User

    @ManyToOne
    private AdModel ad; // Correção para AdModel

    
}
