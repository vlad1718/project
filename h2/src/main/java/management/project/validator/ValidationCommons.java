package management.project.validator;

import management.project.exceptions.ValidationException;

import java.util.Date;

/**
 * Created by vl_gr on 04.11.2015.
 */
public class ValidationCommons {
    public void validate(String name, Date startDate, Date completeDate) throws ValidationException {

        try {
            if (name.isEmpty()) {
                throw (new ValidationException("you input empty project name"));
            } else if (startDate.after(completeDate)) {
                throw (new ValidationException("complete date not to be early start date"));
            }
        }
        catch (NullPointerException e){

        }
    }
}
