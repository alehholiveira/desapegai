package br.com.api.desapegai.Comment;

import org.springframework.stereotype.Service;


@Service
public class CommentService {
    private final CommentRepository commentRepository;

   
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Iterable<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Comment getCommentById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment updateComment(Long id, Comment comment) {
        if (commentRepository.existsById(id)) {
            comment.setId(id);
            return commentRepository.save(comment);
        }
        return null; // Retorna null se o comentário com o ID especificado não for encontrado
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
