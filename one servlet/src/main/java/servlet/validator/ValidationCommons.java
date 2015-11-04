package servlet.validator;

import servlet.exceptions.ValidationException;

import java.util.Date;

/**
 * Created by User on 04.11.2015.
 */
public class ValidationCommons {
    public void validate(String name, Date startDate, Date completeDate) throws ValidationException {


        if (name.isEmpty()) {
            throw (new ValidationException("you input empty project name"));
        } else if (startDate.before(completeDate)) {
            throw (new ValidationException("complete date not to be early start date"));
        }
    }
}
