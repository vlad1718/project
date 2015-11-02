package servlet.validator;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import servlet.comands.LoginCommand;
import servlet.users.UserDao;

import javax.xml.bind.ValidationException;

/**
 * Created by User on 31.10.2015.
 */
public class UserValidator extends Validation  {
    private static final Logger logger =
            LoggerFactory.getLogger(LoginCommand.class);
    public void setUser(UserDao user) {
        this.user = user;
    }

    private UserDao user;
    @Override
    public void validate(String login,String pass) throws ValidationException {
        super.validate(login,pass);
        if (user.search(login,pass).size()!=0) {
            logger.debug("you input valid login and password");
        }

        else if (user.search(login,pass).size()== 0){
            throw new ValidationException("You input not valid login or password ");
        }
    }


}
