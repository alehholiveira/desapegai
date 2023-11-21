package br.com.api.desapegai.Model;
import java.util.List;

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
    @Column(nullable=false)
    private String title;
    @Column(nullable=false)
    private String description;
    @Column(nullable=false)
    private Double price;
    
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
