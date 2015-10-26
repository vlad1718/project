package servlet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import servlet.iterations.IterationDaoImpl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by User on 26.10.2015.
 */
public class Iteration implements Command {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = null;
        HttpSession session = request.getSession(true);
        ApplicationContext context = new ClassPathXmlApplicationContext("module.xml");
        IterationDaoImpl it = (IterationDaoImpl) context.getBean("Iter");

        request.setAttribute("list", it.findIter((Integer)session.getAttribute("project")));
        page ="/listIter.jsp";
        return page;
    }
}
