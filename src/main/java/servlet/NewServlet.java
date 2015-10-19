package servlet;

import com.sun.corba.se.impl.corba.RequestImpl;
import org.flywaydb.core.Flyway;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.context.support.XmlWebApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by User on 14.10.2015.
 */
@WebServlet(name = "NewServlet")
public class NewServlet extends HttpServlet  {



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM");
        String path = request.getRequestURI();
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        ProjectDaoImpl r =(ProjectDaoImpl)context.getBean("ProjectDaoImpl");

        if(path.contains("/first")){

            request.setAttribute("list",r.findAll());
            getServletContext().getRequestDispatcher("/WEB-INF/first.jsp").forward(request, response);
        }
        else if(path.contains("/insert")){

            String name=request.getParameter("name");
            if(name!=null){
                String startDate=request.getParameter("dateBegin");
                String completeDate=request.getParameter("dateComplete");
                Date ps = null;
                Date ds = null;
                try {
                    ps = sdf.parse(startDate);
                    ds = sdf.parse(completeDate);
                } catch (ParseException e) {

                }


                    Projects pr = new Projects(0,name,ps,ds);
                    r.insert(pr);
                    request.setAttribute("list",r.findAll());
                    getServletContext().getRequestDispatcher("/WEB-INF/first.jsp").forward(request, response);



            }
            getServletContext().getRequestDispatcher("/WEB-INF/insert.jsp").forward(request, response);
        }
    }
}
