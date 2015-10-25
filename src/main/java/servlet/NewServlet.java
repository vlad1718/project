package servlet;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import servlet.projects.ProjectDaoImpl;
import servlet.projects.Projects;
import servlet.users.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by User on 14.10.2015.
 */
@WebServlet(name="NewServlet",urlPatterns="/act/*")
public class NewServlet extends HttpServlet  {



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM");
        String path = request.getRequestURI();
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        ProjectDaoImpl r =(ProjectDaoImpl)context.getBean("ProjectDaoImpl");
        if(path.contains("/act/first")){

            request.setAttribute("list",r.findAll());
            getServletContext().getRequestDispatcher("/WEB-INF/com.samsolutions.project/first.jsp").forward(request, response);
        }
        else if(path.contains("/act/insert")){

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
              if (act.equals("Ok")) {
                  r.insert(pr);
              }
                request.setAttribute("list", r.findAll());
            }
                getServletContext().getRequestDispatcher("/WEB-INF/com.samsolutions.project/first.jsp").forward(request, response);
            }
            getServletContext().getRequestDispatcher("/WEB-INF/com.samsolutions.project/insert.jsp").forward(request, response);
        }
        else if (path.contains("/act/login")){
            UserDaoImpl us =(UserDaoImpl)context.getBean("UserDaoImpl");
            String username =  request.getParameter("login");
            String password = request.getParameter("password");

            if(username != null && password != null){
                if(us.search(username,password).size()!=0) {
                    request.setAttribute("list", r.findAll());
                    getServletContext().getRequestDispatcher("/WEB-INF/com.samsolutions.project/first.jsp").forward(request, response);
                }
            }

        }
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }
}
