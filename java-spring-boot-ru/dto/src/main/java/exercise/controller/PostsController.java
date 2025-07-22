package exercise.controller;

import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

import exercise.model.Post;
import exercise.model.Comment;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;
import exercise.dto.PostDTO;
import exercise.dto.CommentDTO;

// BEGIN
@RestController
@RequestMapping("/posts")
public class PostsController {
	
    @Autowired
    private PostRepository repository;
    @Autowired
    private CommentRepository comRepository;
	
	@GetMapping(path = "")
    public List<PostDTO> index() {
        var posts = repository.findAll();
        var result = posts.stream()
                .map(this::toPostDTO)
                .toList();
        return result;		
    }

    @GetMapping(path = "/{id}")
    public PostDTO show(@PathVariable Long id) {
        var post = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));	
        return toPostDTO(post);
    }

	private PostDTO toPostDTO(Post post) {
		var dto = new PostDTO();
		dto.setId(post.getId());
		dto.setTitle(post.getTitle());
		dto.setBody(post.getBody());
        var comm = comRepository.findByPostId(post.getId());
        var result = comm.stream()
                .map(this::toCommentDTO)
                .toList();
		dto.setComments(result);	
		return dto;
	}

	private CommentDTO toCommentDTO(Comment comment) {
		var dto = new CommentDTO();
		dto.setId(comment.getId());
		dto.setBody(comment.getBody());
		return dto;
	}
}
// END
