package servlet.validator;

import servlet.users.User;
import servlet.DAO.UserDao;

import javax.xml.bind.ValidationException;

/**
 * Created by User on 02.11.2015.
 */
public class RegistrationValidator extends Validation {
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    private UserDao userDao;

    public void validate(String login, String pas, String email) throws ValidationException {
        super.validate(login, pas);
        if (login.length() <= 3 || pas.length() <= 3) {
            throw new ValidationException("you input not valid password or login");
        } else {
            User us = new User(login, email, pas);
            userDao.insert(us);

        }
    }
}
