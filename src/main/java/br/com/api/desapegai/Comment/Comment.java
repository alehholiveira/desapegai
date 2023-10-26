package br.com.api.desapegai.Comment; 
import java.util.Date;
import br.com.api.desapegai.Ad.Ad;
import br.com.api.desapegai.User.User; 
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "comments") // Especifica o nome da tabela para CommentModel
public class Comment { 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String text;
    private Date creationDate;

    @ManyToOne
    private User user; 

    @ManyToOne
    private Ad ad; 

    
}
