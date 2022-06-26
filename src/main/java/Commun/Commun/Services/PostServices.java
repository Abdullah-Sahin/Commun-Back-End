package Commun.Commun.Services;

import Commun.Commun.CustomExceptions.InvalidDeadlineException;
import Commun.Commun.CustomExceptions.UserNotFoundException;
import Commun.Commun.Models.User;
import Commun.Commun.Repos.PostRepository;
import Commun.Commun.Models.Post;
import Commun.Commun.Repos.UserRepository;
import Commun.Commun.Requests.CreatePostRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostServices {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Autowired
    public PostServices(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public List<Post> getPosts(Optional<Long> posterId,
                               Optional<Boolean> isClaimed,
                               Optional<Long> claimerId,
                               Optional<Boolean> isCompleted,
                               Optional<String> location) {

        //When claimerId Typed, isClaimed field is automatically true
        if(claimerId.isPresent()){
            //If all fields typed
            if(posterId.isPresent() && isCompleted.isPresent() && location.isPresent()){
                return postRepository.findByPosterId(posterId.get())
                        .stream().filter(post -> post.getClaimer().getId() == claimerId.get())
                        .filter(post -> post.isCompleted() == isCompleted.get())
                        .filter(post -> post.getLocation().equals(location.get()))
                        .toList();
            }
            //If posterId and isCompleted typed
            else if(posterId.isPresent() && isCompleted.isPresent()){
                return postRepository.findByPosterId(posterId.get())
                        .stream().filter(post -> post.getClaimer().getId() == claimerId.get())
                        .filter(post -> post.isCompleted() == isCompleted.get())
                        .toList();
            }
            //If posterId and location typed
            else if(posterId.isPresent() && location.isPresent()){
                return postRepository.findByPosterId(posterId.get())
                        .stream().filter(post -> post.getClaimer().getId() == claimerId.get())
                        .filter(post -> post.getLocation().equals(location.get()))
                        .toList();
            }
            //If isCompeted and location typed
            else if(isCompleted.isPresent() && location.isPresent()){
                return postRepository.findByClaimerId(claimerId.get())
                        .stream().filter(post -> post.isCompleted() == isCompleted.get())
                        .filter(post -> post.getLocation().equals(location.get()))
                        .toList();
            }
            //If posterId typed
            else if(posterId.isPresent()){
                return postRepository.findByPosterId(posterId.get())
                        .stream().filter(post -> post.getClaimer().getId() == claimerId.get())
                        .toList();
            }
            //If isCompleted typed
            else if(isCompleted.isPresent()){
                return postRepository.findByClaimerId(claimerId.get())
                        .stream().filter(post -> post.isCompleted() == isCompleted.get())
                        .toList();
            }
            //If location typed
            else if(location.isPresent()){
                return postRepository.findByClaimerId(claimerId.get())
                        .stream().filter(post -> post.getLocation().equals(location.get()))
                        .toList();
            }
            //If only claimer is typed
            else{
                return postRepository.findByClaimerId(claimerId.get());
            }
        }
        //When claimerId is not typed
        else{
            //If everything else is typed
            if(posterId.isPresent() && isClaimed.isPresent() && isCompleted.isPresent() && location.isPresent()){
                return postRepository.findByPosterId(posterId.get())
                        .stream().filter(post -> post.isClaimed() == isClaimed.get())
                        .filter(post -> post.isCompleted() == isCompleted.get())
                        .filter(post -> post.getLocation().equals(location.get()))
                        .toList();
            }
            //If posterId, isClaimed and isCompleted are typed
            if(posterId.isPresent() && isClaimed.isPresent() && isCompleted.isPresent()){
                return postRepository.findByPosterId(posterId.get())
                        .stream().filter(post -> post.isCompleted() == isCompleted.get())
                        .filter(post -> post.isClaimed() == isClaimed.get())
                        .toList();
            }
            //If posterId, isClaimed and location are typed
            if(posterId.isPresent() && isClaimed.isPresent() && location.isPresent()){
                return postRepository.findByPosterId(posterId.get())
                        .stream().filter(post -> post.isClaimed() == isClaimed.get())
                        .filter(post -> post.getLocation().equals(location.get()))
                        .toList();
            }
            //If posterId, isCompleted and location are typed
            if(posterId.isPresent() && isCompleted.isPresent() && location.isPresent()){
                return postRepository.findByPosterId(posterId.get())
                        .stream().filter(post -> post.isCompleted() == isCompleted.get())
                        .filter(post -> post.getLocation().equals(location.get()))
                        .toList();
            }
            //If isClaimed, isCompleted and location are typed
            if(isClaimed.isPresent() && isCompleted.isPresent() && location.isPresent()){
                return postRepository.findByLocation(location.get())
                        .stream().filter(post -> post.isCompleted() == isCompleted.get())
                        .filter(post -> post.isClaimed() == isClaimed.get())
                        .toList();
            }
            //If posterId and isClaimed are typed
            if(posterId.isPresent() && isClaimed.isPresent()){
                return postRepository.findByPosterId(posterId.get())
                        .stream().filter(post -> post.isClaimed() == isClaimed.get())
                        .toList();
            }
            //If posterId and isCompleted are typed
            if(posterId.isPresent() && isCompleted.isPresent()){
                return postRepository.findByPosterId(posterId.get())
                        .stream().filter(post -> post.isCompleted() == isCompleted.get())
                        .toList();
            }
            //If posterId and location are typed
            if(posterId.isPresent() && location.isPresent()){
                return postRepository.findByPosterId(posterId.get())
                        .stream().filter(post -> post.getLocation().equals(location.get()))
                        .toList();
            }
            //If isClaimed and isCompleted are typed
            if(isClaimed.isPresent() && isCompleted.isPresent()){
                return postRepository.findByClaimed(isClaimed.get())
                        .stream().filter(post -> post.isCompleted() == isCompleted.get())
                        .toList();
            }
            //If isClaimed and location are typed
            if(isClaimed.isPresent() && location.isPresent()){
                return postRepository.findByLocation(location.get())
                        .stream().filter(post -> post.isClaimed() == isClaimed.get())
                        .toList();
            }
            //If isCompleted and location are typed
            if(isCompleted.isPresent() && location.isPresent()){
                return postRepository.findByLocation(location.get())
                        .stream().filter(post -> post.isCompleted() == isCompleted.get())
                        .toList();
            }
            //If posterId is typed
            if(posterId.isPresent()){
                return postRepository.findByPosterId(posterId.get());
            }
            //If isClaimed is typed
            if(isClaimed.isPresent()){
                return postRepository.findByClaimed(isClaimed.get());
            }
            //If isCompleted is typed
            if(isCompleted.isPresent()){
                return postRepository.findByCompleted(isCompleted.get());
            }
            //If location is typed
            if(location.isPresent()){
                return postRepository.findByLocation(location.get());
            }
            //If nothing is typed
            return postRepository.findAll();
        }

    }

    public Post getOnePostByPostId(Long postId){
        return postRepository.findById(postId).orElse(null);
    }


    public Post addPost(CreatePostRequest post) throws InvalidDeadlineException, UserNotFoundException {
        Post newPost = new Post();
        Optional<User> poster = userRepository.findById(post.getPosterId());
        if(poster.isPresent()){
            if(post.getDeadline().isAfter(LocalDateTime.now().plusMinutes(90))) {
                newPost.setPoster(poster.get());
                newPost.setTitle(post.getTitle());
                newPost.setRequest(post.getRequest());
                newPost.setDeadline(post.getDeadline());
                newPost.setLocation(post.getLocation());
                newPost.setReward(post.getReward());
                newPost.setClaimed(false);
                newPost.setClaimer(null);
                newPost.setCompleted(false);
                return newPost;
            }
            else{
                throw new InvalidDeadlineException();
            }
        }
        throw new UserNotFoundException();
    }

    public Post updatePostById(Long id, Post newPost){
        Post post = getOnePostByPostId(id);
        post.setDeadline(newPost.getDeadline());
        post.setTitle(newPost.getTitle());
        post.setRequest(newPost.getRequest());
        return postRepository.save(post);
    }

    public Post deletePostById(Long id){
        Post post = getOnePostByPostId(id);
        postRepository.delete(post);
        return post;
    }

}
