package management.project.comands;

import management.project.Command;
import management.project.exceptions.ValidationException;
import management.project.validator.TaskAddValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by vl_gr on 10.11.2015.
 */
public class AddTaskCommand implements Command {

    public static final String BUTTON = "button";
    public static final String KATEGORY = "Kategory";
    public static final String DESCRIPTION = "Description";
    public static final String ESTIMATED_HOURS = "EstimatedHours";
    public static final String IT = "it";
    public static final String TASKS = "/tasks";
    public static final String ERROR = "error";
    public static final String NEW_TASK_JSP = "/newTask.jsp";

    public void setTaskAddValidator(TaskAddValidator taskAddValidator) {
        this.taskAddValidator = taskAddValidator;
    }

    private TaskAddValidator taskAddValidator;


    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String page = NEW_TASK_JSP;
        String button = request.getParameter(BUTTON);
        if (button != null) {
            String kategory = request.getParameter(KATEGORY);
            String description = request.getParameter(DESCRIPTION);
            String estimatedHours = request.getParameter(ESTIMATED_HOURS);
            int id = (Integer) session.getAttribute(IT);


            try {
                taskAddValidator.vaildate(kategory, description, estimatedHours, id);
                page = TASKS;
            } catch (ValidationException e) {
                request.setAttribute(ERROR, e.getMessage());
            }

        }
        return page;
    }
}
