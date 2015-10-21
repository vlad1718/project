package servlet;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import servlet.iterations.IterationDaoImpl;
import servlet.iterations.Iterations;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by User on 20.10.2015.
 */
@WebServlet(name = "IterationServlet")
public class IterationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getRequestURI();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM");
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        IterationDaoImpl r =(IterationDaoImpl)context.getBean("Iter");
        HttpSession session = request.getSession(true);
        if(path.contains("/serv/listIter")){
            String st = request.getParameter("add");
            if(st!=null) {
                session.setAttribute("project", (Integer.parseInt(st)));
            }
            request.setAttribute("list", r.findIter((Integer)session.getAttribute("project")));


            getServletContext().getRequestDispatcher("/WEB-INF/com.samsolutions.iterations/listIter.jsp").forward(request, response);
        }
        if(path.contains("/serv/newIter")){
            String act = request.getParameter("act");
            if(act!=null){
                String name=request.getParameter("NameIteration");
                if(name!=null) {

                    String desc = request.getParameter("Description");
                    String startDate = request.getParameter("StartDate");
                    String completeDate = request.getParameter("endDate");
                    String status = request.getParameter("status");
                    int pr_id =(Integer) session.getAttribute("project");

                    Date ps = null;
                    Date ds = null;
                    try {
                        ps = sdf.parse(startDate);
                        ds = sdf.parse(completeDate);
                    } catch (ParseException e) {

                    }
                    Iterations pr = new Iterations(0, name,desc, ps, ds,status,pr_id);
                    if (act.equals("Ok")) {
                        r.insert(pr);
                    }

                }
                getServletContext().getRequestDispatcher("/WEB-INF/com.samsolutions.iterations/listIter.jsp").forward(request, response);
            }
            getServletContext().getRequestDispatcher("/WEB-INF/com.samsolutions.iterations/newIter.jsp").forward(request, response);
    }
        if(path.contains("/serv/view")){
             String st = request.getParameter("iter");
            if (st != null)  {
                int n = Integer.parseInt(st);

                request.setAttribute("list", r.findThisIter(n));


            }
            getServletContext().getRequestDispatcher("/WEB-INF/com.samsolutions.iterations/view.jsp").forward(request, response);
        }

    }
}
