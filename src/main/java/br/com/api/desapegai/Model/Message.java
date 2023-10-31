package br.com.api.desapegai.Model;
import java.util.Date;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "messages") // Especifica o nome da tabela para MessageModel
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String text;
    private Date sendDate;

    @ManyToOne
    private User sender; // Remetente da mensagem

    @ManyToOne
    private User recipient; // Destinatário da mensagem
}
