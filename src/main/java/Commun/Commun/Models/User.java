package Commun.Commun.Models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @SequenceGenerator(name="users", sequenceName = "users")
    private long id;
    private String userName;
    private String email;
    private String password;
    private int coins;

}
