package servlet.comands;

import servlet.Command;
import servlet.users.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by User on 24.10.2015.
 */
public class LoginCommand implements Command {
    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";
    public static final String REGISTRATION = "registration";
    public static final String PROJECTS = "/projects";
    public static final String LOGIN_JSP = "/login.jsp";
    private UserDao user;

    public void setUser(UserDao user) {
        this.user = user;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = null;
        HttpSession session = request.getSession();
        String login = request.getParameter(LOGIN);
        String pass = request.getParameter(PASSWORD);
        String command = request.getParameter(REGISTRATION);
        if (user.search(login,pass).size()!=0) {
            session.setAttribute(LOGIN,true);
            page = PROJECTS;

        }
        else {
            page = LOGIN_JSP;
            request.setAttribute("error","Invalid login or password");
        }


        return page;
    }
}
