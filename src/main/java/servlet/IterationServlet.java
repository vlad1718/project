package servlet;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by User on 20.10.2015.
 */
@WebServlet(name = "IterationServlet")
public class IterationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getRequestURI();
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
        IterationDaoImpl r =(IterationDaoImpl)context.getBean("Iter");
        if(path.contains("/serv/listIter")){
            String st = request.getParameter("add");
            if (st != null)  {
                int n = Integer.parseInt(st);

                    request.setAttribute("list", r.findIter(n));

            }

            getServletContext().getRequestDispatcher("/WEB-INF/com.samsolutions.iterations/listIter.jsp").forward(request, response);
        }
    }
}
