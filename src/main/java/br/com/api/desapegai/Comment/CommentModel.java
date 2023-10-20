package br.com.api.desapegai.Comment; 
import java.util.Date;
import br.com.api.desapegai.Ad.AdModel;
import br.com.api.desapegai.User.UserModel; 
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "comments") // Especifica o nome da tabela para CommentModel
public class CommentModel { 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String text;
    private Date creationDate;

    @ManyToOne
    private UserModel user; 

    @ManyToOne
    private AdModel ad; 

    
}
