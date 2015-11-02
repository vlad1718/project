package servlet.validator;

import javax.xml.bind.ValidationException;

/**
 * Created by User on 02.11.2015.
 */
public abstract class Validation {

    public void validate(String login,String pass) throws ValidationException {
        if(login.isEmpty() && pass.isEmpty()){
            throw new ValidationException("login and password are empty!");
        }
        else if(login.isEmpty() || pass.isEmpty()){
            throw new ValidationException("You need to input all fields ");
        }

    }

}
