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
             ArrayList <Tasks> notSt = new ArrayList<Tasks>();
             ArrayList <Tasks> st = new ArrayList<Tasks>();
            ArrayList <Tasks> completed = new ArrayList<Tasks>();
            for (Tasks task : (List<Tasks>) r.findTasks((Integer) session.getAttribute("it"))){
                if (task.getT_kategory().equals("not started")){
                    notSt.add(task);
                    request.setAttribute("not started",notSt);
                }
                if (task.getT_kategory().equals("started")){
                    st.add(task);

                    request.setAttribute("started",st);
                }
                if (task.getT_kategory().equals("completed")){
                    completed.add(task);
                    request.setAttribute("completed",completed);
                }
            }
            getServletContext().getRequestDispatcher("/WEB-INF/view.jsp").forward(request, response);
        }
    }
}
