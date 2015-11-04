package servlet.comands;

import servlet.Command;
import servlet.exceptions.ValidationException;
import servlet.validator.ProjectAddValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by User on 28.10.2015.
 */
public class AddProjectCommand implements Command {
    public static final String INSERT_JSP = "/insert.jsp";
    public static final String ACT = "act";
    public static final String NAME_PROJECT = "NameProject";
    public static final String DATE_BEGIN = "DateBegin";
    public static final String DATE_COMPLETE = "DateComplete";
    public static final String PROJECTS = "/projects";
    public static final String ERROR = "error";


    private ProjectAddValidator projectAddValidator;

    public void setProjectAddValidator(ProjectAddValidator projectAddValidator) {
        this.projectAddValidator = projectAddValidator;
    }


    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = INSERT_JSP;
        String act = request.getParameter(ACT);
        if (act != null) {
            String name = request.getParameter(NAME_PROJECT);
            String startDate = request.getParameter(DATE_BEGIN);
            String completeDate = request.getParameter(DATE_COMPLETE);
            try{
               projectAddValidator.validate(name,startDate,completeDate);
                page = PROJECTS;
            }
           catch (ValidationException e) {
               request.setAttribute(ERROR, e.getMessage());
            }

        }
        return page;
    }
}