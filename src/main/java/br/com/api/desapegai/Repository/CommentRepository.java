package br.com.api.desapegai.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.api.desapegai.Model.Comment;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long>{
    
}
