package br.com.api.desapegai.Comment;


import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/comments")
public class CommentController {
    private final CommentService commentService;


    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping
    public Iterable<CommentModel> getAllComments() {
        return commentService.getAllComments();
    }

    @GetMapping("/{id}")
    public CommentModel getCommentById(@PathVariable Long id) {
        return commentService.getCommentById(id);
    }

    @PostMapping
    public CommentModel createComment(@RequestBody CommentModel comment) {
        return commentService.createComment(comment);
    }

    @PutMapping("/{id}")
    public CommentModel updateComment(@PathVariable Long id, @RequestBody CommentModel comment) {
        return commentService.updateComment(id, comment);
    }

    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
    }
}
