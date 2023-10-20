package br.com.api.desapegai.Message;
import java.util.Date;
import br.com.api.desapegai.User.UserModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "messages") // Especifica o nome da tabela para MessageModel
public class MessageModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String text;
    private Date sendDate;

    @ManyToOne
    private UserModel sender; // Remetente da mensagem

    @ManyToOne
    private UserModel recipient; // Destinatário da mensagem
}
