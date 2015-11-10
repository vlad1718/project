package management.project.comands;

import management.project.Command;
import management.project.exceptions.ValidationException;
import management.project.validator.IterationAddValidator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by vl_gr on 28.10.2015.
 */
public class AddIterationCommand implements Command {
    public static final String DESCRIPTION = "Description";
    public static final String START_DATE = "StartDate";
    public static final String END_DATE = "endDate";
    public static final String STATUS = "status";
    public static final String PROJECT = "project";
    public static final String ITERATIONS = "/iterations";
    public static final String NAME_ITERATION = "NameIteration";
    public static final String ACT = "act";
    public static final String NEW_ITER_JSP = "/newIter.jsp";
    public static final String ERROR = "error";
    public static final String OK = "Ok";
    public static final String LIST_ITER_JSP = "/listIter.jsp";

    public void setIterationAddValidator(IterationAddValidator iterationAddValidator) {
        this.iterationAddValidator = iterationAddValidator;
    }

    private IterationAddValidator iterationAddValidator;

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(true);
        String page = NEW_ITER_JSP;

        String act = request.getParameter(ACT);
        if (act != null) {
            String name = request.getParameter(NAME_ITERATION);
            String desc = request.getParameter(DESCRIPTION);
            String startDate = request.getParameter(START_DATE);
            String completeDate = request.getParameter(END_DATE);
            String status = request.getParameter(STATUS);
            int pr_id = (Integer) session.getAttribute(PROJECT);
            if (act.equals(OK)) {
                try {
                    iterationAddValidator.validate(name, desc, startDate, completeDate, status, pr_id);
                    page = ITERATIONS;
                } catch (ValidationException e) {
                    request.setAttribute(ERROR, e.getMessage());
                }
            }
            else page = LIST_ITER_JSP;

        }
        return page;
    }
}
