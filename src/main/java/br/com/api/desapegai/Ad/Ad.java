package br.com.api.desapegai.Ad;
import java.util.List;
import br.com.api.desapegai.Category.Category;
import br.com.api.desapegai.Comment.Comment;
import br.com.api.desapegai.User.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "ads")
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private Double price;
    private String location;
    
    @ManyToOne
    private Category category;
    
    @OneToMany(mappedBy = "ad")
    private List<Comment> comments; // Comentários relacionados ao anúncio

    @ManyToOne
    private User seller; // Usuário que publicou o anúncio

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] images; // Imagens relacionadas ao anúncio

    private Date publicationDate;
    private String status; // Ativo, expirado, vendido, etc.
}
