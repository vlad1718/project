package servlet.comands;

import servlet.Command;
import servlet.projects.ProjectDao;
import servlet.projects.Projects;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by User on 28.10.2015.
 */
public class AddProjectCommand implements Command {
    public static final String YYYY_DD_MM = "yyyy-dd-MM";
    public static final String INSERT_JSP = "/insert.jsp";
    public static final String ACT = "act";
    public static final String NAME_PROJECT = "NameProject";
    public static final String DATE_BEGIN = "DateBegin";
    public static final String DATE_COMPLETE = "DateComplete";
    public static final String PROJECTS = "/projects";
    public static final String OK = "Ok";
    private ProjectDao p;


    public void setP(ProjectDao p) {
        this.p = p;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_DD_MM);
        String page = INSERT_JSP;
        String act = request.getParameter(ACT);
        if (act != null) {
            String name = request.getParameter(NAME_PROJECT);
            if (name != null) {

                String startDate = request.getParameter(DATE_BEGIN);
                String completeDate = request.getParameter(DATE_COMPLETE);
                Date ps = null;
                Date ds = null;
                try {
                    ps = sdf.parse(startDate);
                    ds = sdf.parse(completeDate);
                } catch (ParseException e) {

                }
                Projects pr = new Projects(name, ps, ds);
                if (act.equals(OK)) {
                    p.insert(pr);
                }
            }
            page = PROJECTS;

        }
        return page;
    }
}