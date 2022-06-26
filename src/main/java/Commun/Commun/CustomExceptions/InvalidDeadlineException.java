package Commun.Commun.CustomExceptions;

public class InvalidDeadlineException extends Exception{

    @Override
    public String getMessage() {
        return "Deadline of a post should be at least 90 mins" +
                " after its creation";
    }

}
