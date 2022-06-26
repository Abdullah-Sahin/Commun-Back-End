package Commun.Commun.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
@Data
public class Post {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String request;
    private LocalDateTime deadline;
    private String location;
    private int reward;
    private boolean claimed;
    private boolean completed;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "posterId", nullable = false)
    @JsonIgnore
    private User poster;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "claimerId")
    @JsonIgnore
    private User claimer;
}
