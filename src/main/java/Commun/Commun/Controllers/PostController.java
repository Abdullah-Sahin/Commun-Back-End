package Commun.Commun.Controllers;

import Commun.Commun.CustomExceptions.InvalidDeadlineException;
import Commun.Commun.CustomExceptions.UserNotFoundException;
import Commun.Commun.Models.Post;
import Commun.Commun.Requests.CreatePostRequest;
import Commun.Commun.Services.PostServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "commun/posts")
public class PostController {

    private final PostServices postServices;

    @Autowired
    public PostController(PostServices postServices) {
        this.postServices = postServices;
    }

    @GetMapping
    public List<Post> getAllPosts(@RequestParam Optional<Long> posterId,
                                  @RequestParam Optional<Boolean> isClaimed,
                                  @RequestParam Optional<Long> claimerId,
                                  @RequestParam Optional<Boolean> isCompleted,
                                  @RequestParam Optional<String> location){

        return postServices.getPosts(posterId, isClaimed, claimerId, isCompleted, location);
    }

    @GetMapping(path = "/{id}")
    public Post getPostById(@PathVariable Long id){
        return postServices.getOnePostByPostId(id);
    }

    @PostMapping
    public Post addPost(@RequestBody CreatePostRequest post) throws UserNotFoundException, InvalidDeadlineException {
        return postServices.addPost(post);
    }

    @PutMapping(path = "/{id}")
    public Post updatePostById(@PathVariable Long id, @RequestBody Post newPost){
        return postServices.updatePostById(id, newPost);
    }

    @DeleteMapping(path = "/{id}")
    public Post deletePostById(@PathVariable Long id){
        return postServices.deletePostById(id);
    }
}
