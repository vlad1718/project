package servlet.comands;

import servlet.Command;
import servlet.DAO.ProjectDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by User on 25.10.2015.
 */
public class ProjectCommand implements Command {
    public static final String LIST = "list";
    public static final String FIRST_JSP = "/first.jsp";
    public static final String ADD = "add";
    public static final String PROJECT = "project";
    public static final String ITERATIONS = "/iterations";
    private ProjectDao p;


    public void setP(ProjectDao p) {
        this.p = p;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = null;
        HttpSession session = request.getSession(true);
        request.setAttribute(LIST, p.findAll());
        page = FIRST_JSP;
        String st = request.getParameter(ADD);

        if (st != null) {

            session.setAttribute(PROJECT, (Integer.parseInt(st)));
            page = ITERATIONS;
        }

        return page;
    }
}

