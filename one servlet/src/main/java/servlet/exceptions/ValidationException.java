package servlet.exceptions;

/**
 * Created by User on 02.11.2015.
 */
public class ValidationException extends Exception {
    public ValidationException() {
     super();
    }

    public ValidationException(String message) {
    super(message);
    }


}
