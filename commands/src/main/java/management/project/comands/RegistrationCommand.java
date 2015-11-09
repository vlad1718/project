package management.project.comands;

import management.project.Command;
import management.project.validator.RegistrationValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.ValidationException;
import java.io.IOException;

/**
 * Created by vl_gr on 28.10.2015.
 */
public class RegistrationCommand implements Command {

    public static final String USERNAME = "username";
    public static final String LOGIN_JSP = "/login.jsp";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";
    public static final String REGISTRATE_USER_JSP = "/RegistrateUser.jsp";
    public static final String ENTER = "enter";
    public static final String ERROR = "error";
    public static final String YOU_REGISTERED_SUCCESSFULLY = "you registered successfully";
    public static final String OK = "ok";


    public void setRegistrationValidator(RegistrationValidator registrationValidator) {
        this.registrationValidator = registrationValidator;
    }

    private RegistrationValidator registrationValidator;

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String button = request.getParameter(ENTER);
        String page = REGISTRATE_USER_JSP;
        if (button != null) {
            String username = request.getParameter(USERNAME);
            String password = request.getParameter(PASSWORD);
            String email = request.getParameter(EMAIL);
            if(button.equals(OK)){
            try {
                registrationValidator.validate(username, password, email);
                request.setAttribute(ERROR, YOU_REGISTERED_SUCCESSFULLY);
                page = LOGIN_JSP;
            } catch (ValidationException e) {
                request.setAttribute(ERROR, e.getMessage());
            }

            } else page = LOGIN_JSP;
        }
        return page;
    }
}
