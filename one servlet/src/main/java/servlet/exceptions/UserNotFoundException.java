package servlet.exceptions;

/**
 * Created by User on 02.11.2015.
 */
public class UserNotFoundException extends Exception {
    public UserNotFoundException() {
     super();
    }

    public UserNotFoundException(String message) {
    super(message);
    }


}
