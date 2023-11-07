package br.com.api.desapegai.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.api.desapegai.Model.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, Long>{
    
}
