package src.common.exceptions;

public class UserDoesntExistException extends Exception {
    public UserDoesntExistException() {
        super("User doesnt exists!");
    }
}
