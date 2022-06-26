package Commun.Commun.CustomExceptions;

public class UserNotFoundException extends Exception{

    @Override
    public String getMessage(){
        return "User with specified Id not found";
    }
}
