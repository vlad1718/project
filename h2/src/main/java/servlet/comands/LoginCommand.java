package servlet.comands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import servlet.Command;
import servlet.validator.UserValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.ValidationException;
import java.io.IOException;


/**
 * Created by vl_gr on 24.10.2015.
 */
public class LoginCommand implements Command {
    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";
    public static final String PROJECTS = "/projects";
    public static final String LOGIN_JSP = "/login.jsp";
    public static final String ERROR = "error";
    private UserValidator userValidator;
    private static final Logger logger =
            LoggerFactory.getLogger(LoginCommand.class);

    public void setUserValidator(UserValidator userValidator) {
        this.userValidator = userValidator;
    }


    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = null;
        HttpSession session = request.getSession();
        String login = request.getParameter(LOGIN);
        String pass = request.getParameter(PASSWORD);

        try {
            userValidator.validate(login, pass);
            session.setAttribute(LOGIN, true);
            page = PROJECTS;
        } catch (ValidationException e) {
            logger.debug("you not input valid values");
            request.setAttribute(ERROR, e.getMessage());
            page = LOGIN_JSP;
        }


        return page;
    }

}
