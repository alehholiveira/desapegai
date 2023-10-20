package br.com.api.desapegai.AdImage;
import br.com.api.desapegai.Ad.AdModel;
import jakarta.persistence.*;

@Entity
@Table(name="ad_image")
public class AdImageModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private AdModel ad; // Associação com o anúncio

    
}

