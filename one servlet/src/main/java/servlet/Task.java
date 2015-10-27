package servlet;

import servlet.tasks.TaskDaoImpl;
import servlet.tasks.Tasks;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 27.10.2015.
 */
public class Task implements Command {
    private TaskDaoImpl task;

    public TaskDaoImpl getTask() {
        return task;
    }

    public void setTask(TaskDaoImpl task) {
        this.task = task;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getRequestURI();
        HttpSession session = request.getSession(true);

        ArrayList<Tasks> notSt = new ArrayList<Tasks>();
        ArrayList <Tasks> st = new ArrayList<Tasks>();
        ArrayList <Tasks> completed = new ArrayList<Tasks>();
        for (Tasks tasks : (List<Tasks>) task.findTasks((Integer) session.getAttribute("it"))){
            if (tasks.getT_kategory().equals("not started")){
                notSt.add(tasks);
                request.setAttribute("not started",notSt);
            }
            if (tasks.getT_kategory().equals("started")){
                st.add(tasks);

                request.setAttribute("started",st);
            }
            if (tasks.getT_kategory().equals("completed")){
                completed.add(tasks);
                request.setAttribute("completed",completed);
            }
        }
        String page ="/viewTasks.jsp";
        return page;
    }
}
