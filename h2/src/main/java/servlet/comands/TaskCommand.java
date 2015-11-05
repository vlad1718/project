package servlet.comands;

import servlet.Command;
import servlet.DAO.TaskDao;
import servlet.tasks.Task;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vl_gr on 27.10.2015.
 */
public class TaskCommand implements Command {
    private TaskDao task;

    public void setTask(TaskDao task) {
        this.task = task;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        ArrayList<Task> notSt = new ArrayList<Task>();
        ArrayList<Task> st = new ArrayList<Task>();
        ArrayList<Task> completed = new ArrayList<Task>();
         for (Task tasks : (List<Task>) task.findTasks((Integer) session.getAttribute("it"))) {
            if (tasks.getKategory().equals("not started")) {
                notSt.add(tasks);
                request.setAttribute("not started", notSt);
            }
            if (tasks.getKategory().equals("started")) {
                st.add(tasks);

                request.setAttribute("started", st);
            }
            if (tasks.getKategory().equals("completed")) {
                completed.add(tasks);
                request.setAttribute("completed", completed);
            }
        }

        String page = "/viewTasks.jsp";

    return page;}

}
