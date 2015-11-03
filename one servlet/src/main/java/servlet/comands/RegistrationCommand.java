package servlet.comands;

import servlet.Command;
import servlet.validator.RegistrationValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.ValidationException;
import java.io.IOException;

/**
 * Created by User on 28.10.2015.
 */
public class RegistrationCommand implements Command {

    public static final String USERNAME = "username";
    public static final String LOGIN_JSP = "/login.jsp";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String REGISTRATE_USER_JSP = "/RegistrateUser.jsp";
    public static final String ENTER = "enter";
    public static final String ERROR = "error";


    public void setRegistrationValidator(RegistrationValidator registrationValidator) {
        this.registrationValidator = registrationValidator;
    }
    private RegistrationValidator registrationValidator;

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter(USERNAME);
        String password = request.getParameter(PASSWORD);
        String email = request.getParameter(EMAIL);
        String button = request.getParameter(ENTER);
        String page = REGISTRATE_USER_JSP;
        if(button!=null) {
            try {
                registrationValidator.validate(username, password,email);

                page = LOGIN_JSP;
            } catch (ValidationException e) {
                request.setAttribute(ERROR, e.getMessage());

            }
        }
        return page;
    }
}
