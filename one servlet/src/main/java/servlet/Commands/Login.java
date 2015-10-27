package servlet.Commands;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import servlet.Command;
import servlet.users.UserDaoImpl;
import servlet.users.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.registry.infomodel.User;
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
        String path = request.getRequestURI();

        String login = request.getParameter("login");
        String pass = request.getParameter("password");

        if (user.search(login,pass).size()!=0) {
            page = "/controller?command=projects";

        }
        else page ="/login.jsp";
        if(path.contains("/Registrate.action")){
            String username = request.getParameter("username");
            if(username!=null){
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                Users us = new Users(username,email,password);
                user.insert(us);
            }

        }
        return page;
    }
}
