package br.com.api.desapegai.Ad;
import java.util.List;
import br.com.api.desapegai.AdImage.AdImageModel;
import br.com.api.desapegai.Category.CategoryModel;
import br.com.api.desapegai.Comment.CommentModel;
import br.com.api.desapegai.User.UserModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "ads") // Especifica o nome da tabela para AdModel
public class AdModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Double price;
    private String location;
    
    @ManyToOne
    private CategoryModel category;
    
    @OneToMany(mappedBy = "ad")
    private List<CommentModel> comments; // Comentários relacionados ao anúncio

    @ManyToOne
    private UserModel seller; // Usuário que publicou o anúncio

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "ad_id")
    private List<AdImageModel> images; // Imagens relacionadas ao anúncio

    private Date publicationDate;
    private String status; // Ativo, expirado, vendido, etc.
}
