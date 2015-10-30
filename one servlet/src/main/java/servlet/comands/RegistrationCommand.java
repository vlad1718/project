package servlet.comands;

import servlet.Command;
import servlet.users.UserDao;
import servlet.users.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    public UserDao getUser() {
        return user;
    }

    public void setUser(UserDao user) {
        this.user = user;
    }

    private UserDao user;
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter(USERNAME);
        String page = REGISTRATE_USER_JSP;
        if(username!=null){
            String email = request.getParameter(EMAIL);
            String password = request.getParameter(PASSWORD);
            Users us = new Users(username,email,password);
            user.insert(us);
            page = LOGIN_JSP;
        }
        return page;
    }
}
