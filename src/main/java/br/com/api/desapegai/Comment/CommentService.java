package br.com.api.desapegai.Comment;

import org.springframework.stereotype.Service;


@Service
public class CommentService {
    private final CommentRepository commentRepository;

   
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Iterable<CommentModel> getAllComments() {
        return commentRepository.findAll();
    }

    public CommentModel getCommentById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    public CommentModel createComment(CommentModel comment) {
        return commentRepository.save(comment);
    }

    public CommentModel updateComment(Long id, CommentModel comment) {
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
