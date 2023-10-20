package br.com.api.desapegai.Message;
import java.util.Date;
import br.com.api.desapegai.User.UserModel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class MessageModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private Date sendDate;

    @ManyToOne
    private UserModel sender; // Remetente da mensagem

    @ManyToOne
    private UserModel recipient; // Destinatário da mensagem
}
