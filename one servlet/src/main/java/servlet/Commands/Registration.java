package servlet.Commands;

import servlet.Command;
import servlet.users.UserDaoImpl;
import servlet.users.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by User on 28.10.2015.
 */
public class Registration implements Command {
    public UserDaoImpl getUser() {
        return user;
    }

    public void setUser(UserDaoImpl user) {
        this.user = user;
    }

    private UserDaoImpl user;
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String page = "/login.jsp";
        if(username!=null){
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            Users us = new Users(username,email,password);
            user.insert(us);


        }
        return page;
    }
}
