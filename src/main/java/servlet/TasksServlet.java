package servlet;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import servlet.iterations.Iterations;
import servlet.tasks.TaskDaoImpl;
import servlet.tasks.Tasks;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 22.10.2015.
 */
@WebServlet(name="TasksServlet",urlPatterns="/tasks/*")
public class TasksServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getRequestURI();
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        TaskDaoImpl r =(TaskDaoImpl)context.getBean("Tasks");
        HttpSession session = request.getSession(true);
        if(path.equals("/tasks/view")){

            request.setAttribute("task",r.findTasks((Integer)session.getAttribute("it")));
            getServletContext().getRequestDispatcher("/WEB-INF/view.jsp").forward(request, response);
        }
    }
}
