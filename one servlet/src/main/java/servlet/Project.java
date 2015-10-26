package servlet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import servlet.projects.ProjectDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by User on 25.10.2015.
 */
public class Project implements Command {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = null;
        ApplicationContext context = new ClassPathXmlApplicationContext("module.xml");
        ProjectDaoImpl pr = (ProjectDaoImpl) context.getBean("ProjectDaoImpl");
        request.setAttribute("list",pr.findAll());
        page = "/first.jsp";
        return page;
    }
}
