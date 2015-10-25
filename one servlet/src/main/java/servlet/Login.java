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
    private RequestHelp command;
    private Project pr;
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = null;
        ApplicationContext context = new ClassPathXmlApplicationContext("module.xml");
        UserDaoImpl use = (UserDaoImpl) context.getBean("UserDaoImpl");
        String login = request.getParameter("login");
        String pass = request.getParameter("password");

        if (use.search(login,pass).size()!=0) {
            
            page = "/WEB-INF/com.samsolutions.project/first.jsp";

        }
        else page ="/WEB-INF/login.jsp";
        return page;
    }
}
