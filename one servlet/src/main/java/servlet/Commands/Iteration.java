package servlet.Commands;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import servlet.Command;
import servlet.iterations.IterationDaoImpl;
import servlet.iterations.Iterations;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by User on 26.10.2015.
 */
public class Iteration implements Command {
    private IterationDaoImpl it;

    public IterationDaoImpl getIt() {
        return it;
    }

    public void setIt(IterationDaoImpl it) {
        this.it = it;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM");
        HttpSession session = request.getSession(true);


        request.setAttribute("list", it.findIter((Integer) session.getAttribute("project")));
        page = "/listIter.jsp";

     /*   String path = request.getRequestURI();
        if (path.contains("iteration/add.action")) {
            page = "/newIter.jsp";
        }
        if (path.contains("/iteration/insert.action")) {
            String act = request.getParameter("act");
            if (act != null) {
                String name = request.getParameter("NameIteration");
                if (name != null) {

                    String desc = request.getParameter("Description");
                    String startDate = request.getParameter("StartDate");
                    String completeDate = request.getParameter("endDate");
                    String status = request.getParameter("status");
                    int pr_id = (Integer) session.getAttribute("project");

                    Date ps = null;
                    Date ds = null;
                    try {
                        ps = sdf.parse(startDate);
                        ds = sdf.parse(completeDate);
                    } catch (ParseException e) {

                    }
                    Iterations pr = new Iterations(0, name, desc, ps, ds, status, pr_id);
                    if (act.equals("Ok")) {
                        it.insert(pr);
                    }
                }

            page="/controller?command=iterations";
            }
        }
        if(path.contains("/iteration/view.action")){
            String st = request.getParameter("iter");
            if (st != null) {

                session.setAttribute("it", Integer.parseInt(st));
            }
            request.setAttribute("list", it.findThisIter((Integer)session.getAttribute("it")));

            String str = request.getParameter("del");
            if(str!=null) {

                it.del((Integer) session.getAttribute("it"));
                page="/controller?command=iterations";
            }
            else page = "/view.jsp";

        }
        if(path.contains("/iteration/tasks")){
            page = "/controller?command=tasks";
        }*/
        return page;

    }
}


