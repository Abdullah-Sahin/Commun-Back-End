package Commun.Commun.Services;

import Commun.Commun.Repos.UserRepository;
import Commun.Commun.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices{

    private final UserRepository userRepository;

    @Autowired
    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    public User addUser(User user){
        return userRepository.save(user);
    }

    public User updateUserById(Long id, User newUser){
        User foundUser = getUserById(id);
        foundUser.setUserName(newUser.getUserName());
        foundUser.setEmail(newUser.getEmail());
        foundUser.setPassword(newUser.getPassword());
        return userRepository.save(foundUser);
    }

    public User deleteUserById(Long id){
        User user = getUserById(id);
        userRepository.delete(user);
        return user;
    }

}
