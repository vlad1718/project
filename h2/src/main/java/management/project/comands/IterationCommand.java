package management.project.comands;

import management.project.Command;
import management.project.DAO.IterationDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by vl_gr on 26.10.2015.
 */
public class IterationCommand implements Command {

    public static final String LIST_ITER_JSP = "/listIter.jsp";
    public static final String PROJECT = "project";
    public static final String LIST = "list";

    private IterationDao it;


    public void setIt(IterationDao it) {
        this.it = it;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = null;
        HttpSession session = request.getSession(true);
        session.setAttribute(LIST, it.findIter((Integer) session.getAttribute(PROJECT)));
        page = LIST_ITER_JSP;

        return page;

    }
}


