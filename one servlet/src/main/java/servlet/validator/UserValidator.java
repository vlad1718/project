package servlet.validator;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import servlet.comands.LoginCommand;
import servlet.exceptions.UserNotFoundException;
import servlet.users.UserDao;

/**
 * Created by User on 31.10.2015.
 */
public class UserValidator  {
    private static final Logger logger =
            LoggerFactory.getLogger(LoginCommand.class);
    public void setUser(UserDao user) {
        this.user = user;
    }

    private UserDao user;
    public void validate(String login,String pass) throws UserNotFoundException {

        if (user.search(login,pass).size()!=0) {
            logger.debug("you input valid login and password");
        }
      else if(login.isEmpty() && pass.isEmpty()){
          throw new UserNotFoundException("login and password are empty!");
      }
      else if(login.isEmpty() || pass.isEmpty()){
         throw new UserNotFoundException("You need to input all fields ");
      }
        else if (user.search(login,pass).size()== 0){
            throw new UserNotFoundException("You input not valid login or password ");
        }
    }


}
