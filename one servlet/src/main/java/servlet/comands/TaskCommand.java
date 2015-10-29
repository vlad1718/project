package servlet.comands;

import servlet.Command;
import servlet.tasks.TaskDao;
import servlet.tasks.Tasks;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by User on 27.10.2015.
 */
public class TaskCommand implements Command {
    private TaskDao task;

    public void setTask(TaskDao task) {
        this.task = task;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Tasks> notSt = new ArrayList<Tasks>();
        ArrayList <Tasks> st = new ArrayList<Tasks>();
        ArrayList <Tasks> completed = new ArrayList<Tasks>();
      /* for (Tasks tasks : (List<Tasks>) task.findTasks((Integer) session.getAttribute("it"))){
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
        }*/
        String page ="/viewTasks.jsp";
        return page;
    }
}
