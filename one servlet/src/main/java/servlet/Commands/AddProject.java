package servlet.Commands;

import servlet.Command;
import servlet.projects.ProjectDaoImpl;
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
public class AddProject implements Command {
    private ProjectDaoImpl p;

    public ProjectDaoImpl getP() {
        return p;
    }

    public void setP(ProjectDaoImpl p) {
        this.p = p;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM");
        String page = "/insert.jsp";
        String act = request.getParameter("act");
        if (act != null) {
            String name = request.getParameter("NameProject");
            if (name != null) {

                String startDate = request.getParameter("DateBegin");
                String completeDate = request.getParameter("DateComplete");
                Date ps = null;
                Date ds = null;
                try {
                    ps = sdf.parse(startDate);
                    ds = sdf.parse(completeDate);
                } catch (ParseException e) {

                }
                Projects pr = new Projects(0, name, ps, ds);
                if (act.equals("Ok")) {
                    p.insert(pr);
                }
            }
            page = "/projects";

        }
        return page;
    }
}