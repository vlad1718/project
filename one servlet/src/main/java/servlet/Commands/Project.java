package servlet.Commands;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import servlet.Command;
import servlet.projects.ProjectDaoImpl;
import servlet.projects.Projects;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by User on 25.10.2015.
 */
public class Project implements Command {
    private ProjectDaoImpl p;

    public ProjectDaoImpl getP() {
        return p;
    }

    public void setP(ProjectDaoImpl p) {
        this.p = p;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = null;
        String path = request.getRequestURI();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM");
        HttpSession session = request.getSession(true);

        request.setAttribute("list", p.findAll());
        page = "/first.jsp";
        String st = request.getParameter("add");

        if(st!=null) {

            session.setAttribute("project", (Integer.parseInt(st)));
        }
        if (path.contains("/projects.action")){
            page = "/controller?command=iterations";
        }
        if (path.contains("/projects/add.action")){
            page = "/insert.jsp";
        }
        if(path.contains("/projects/insert.action")){
            String act = request.getParameter("act");
            if(act!=null){
                String name=request.getParameter("NameProject");
                if(name!=null) {

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
                        if(act.equals("Ok")) {
                            p.insert(pr);
                        }
                }
        }

            page = "/controller?command=projects";
             }
        return page;
    }
}

