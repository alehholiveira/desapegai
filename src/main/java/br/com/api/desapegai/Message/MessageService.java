package br.com.api.desapegai.Message;

import org.springframework.stereotype.Service;

@Service
public class MessageService {
    private final MessageRepository messageRepository;


    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Iterable<MessageModel> getAllMessages() {
        return messageRepository.findAll();
    }

    public MessageModel getMessageById(Long id) {
        return messageRepository.findById(id).orElse(null);
    }

    public MessageModel createMessage(MessageModel message) {
        return messageRepository.save(message);
    }

    public void deleteMessage(Long id) {
        messageRepository.deleteById(id);
    }
}
