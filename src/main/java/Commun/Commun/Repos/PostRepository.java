package Commun.Commun.Repos;

import Commun.Commun.Models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByPosterId(Long posterId);

    List<Post> findByClaimerId(Long claimerId);

    List<Post> findByLocation(String location);

    List<Post> findByClaimed(Boolean claimed);

    List<Post> findByCompleted(Boolean completed);
}
