package servlet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import servlet.users.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by User on 24.10.2015.
 */
public class Login  implements Command {
    private UserDaoImpl user;

    public UserDaoImpl getUser() {
        return user;
    }

    public void setUser(UserDaoImpl user) {
        this.user = user;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = null;


        String login = request.getParameter("login");
        String pass = request.getParameter("password");

        if (user.search(login,pass).size()!=0) {
            page = "/controller?command=projects";

        }
        else page ="/login.jsp";

        return page;
    }
}
