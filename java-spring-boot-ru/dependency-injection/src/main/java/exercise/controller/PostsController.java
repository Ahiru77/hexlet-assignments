package exercise.controller;

import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.HttpStatus;
import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;

// BEGIN
@RestController
@RequestMapping("/posts")
public class PostsController {
	
    @Autowired
    private PostRepository postRepository;
	
	@Autowired
    private CommentRepository commentRepository;

    @GetMapping(path = "")
    public List<Post> index() {
        return postRepository.findAll();
    }
	
	@GetMapping(path = "/{id}")
    public Post show(@PathVariable long id) {
        var post =  postRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));

        return post;
    }
	
    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public Post create(@RequestBody Post post) {
		List<Post> posts = postRepository.findAll();
		return postRepository.save(post);
        }
		
    @PutMapping(path = "/{id}")
    public Post update(@PathVariable long id, @RequestBody Post postData) {
        var post =  postRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));

        post.setTitle(postData.getTitle());
        post.setBody(postData.getBody());

        postRepository.save(post);

        return post;
    }

    @DeleteMapping(path = "/{id}")
    public void delete(@PathVariable long id) {
        postRepository.deleteById(id);
		commentRepository.deleteByPostId(id);
    }	
}

// END
