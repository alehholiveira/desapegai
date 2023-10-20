package br.com.api.desapegai.Ad;

import java.util.List;

import javax.imageio.IIOImage;
import javax.xml.stream.events.Comment;
import br.com.api.desapegai.Category.CategoryModel;
import br.com.api.desapegai.User.UserModel;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@Entity
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
    private List<Comment> comments; // Comentários relacionados ao anúncio

    @ManyToOne
    private UserModel seller; // Usuário que publicou o anúncio

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "ad_id")
    private List<IIOImage> images; // Imagens relacionadas ao anúncio

    private Date publicationDate;
    private String status; // Ativo, expirado, vendido, etc.
}
