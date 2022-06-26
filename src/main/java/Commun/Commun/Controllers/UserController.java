package Commun.Commun.Controllers;

import Commun.Commun.Models.User;
import Commun.Commun.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/commun/users")
public class UserController {

    private final UserServices userServices;

    @Autowired
    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userServices.getAllUsers();
    }

    @GetMapping(path = "/{id}")
    public User getUserById(@PathVariable Long id){
        return userServices.getUserById(id);
    }

    @PostMapping
    public User addUser(@RequestBody User user){
        return userServices.addUser(user);
    }

    @PutMapping(path = "/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User newUser){
        return userServices.updateUserById(id, newUser);
    }

    @DeleteMapping(path = "/{id}")
    public User deleteUser(@PathVariable Long id){
        return userServices.deleteUserById(id);
    }
}
