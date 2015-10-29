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
    private UserDao user;

    public void setUser(UserDao user) {
        this.user = user;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = null;
        String path = request.getRequestURI();
        HttpSession session = request.getSession();
        String login = request.getParameter("login");
        String pass = request.getParameter("password");

        if (user.search(login,pass)!=null) {
            session.setAttribute("login",true);
            page = "/projects";

        }
        else page ="/login.jsp";


        return page;
    }
}
