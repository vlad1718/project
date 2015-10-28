package servlet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import servlet.Commands.Login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by User on 24.10.2015.
 */

public class Controller extends HttpServlet implements  javax.servlet.Servlet {
    RequestHelp requestH = RequestHelp.getInstance();
    public Controller(){
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        processRequest(request, response);
        }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String page = null;
        ApplicationContext cont = new ClassPathXmlApplicationContext("module.xml");
         RequestHelp rq = (RequestHelp) cont.getBean("main");
        Command command = requestH.getCommand(request);
        HttpSession session = request.getSession(true);
        session.setAttribute("login", session.getAttribute("login") == null ? false : session.getAttribute("login"));
        if (session.getAttribute("login").equals(true) || command instanceof Login)
        {
            page = command.execute(request, response);

            if (!page.contains("?")) {
                RequestDispatcher dispatcher =
                        getServletContext().getRequestDispatcher(page);
                dispatcher.forward(request, response);
            } else {
                request.getServletContext().getContextPath();
                response.sendRedirect(page);
            }
        }
        else response.sendRedirect("/login.jsp");
    }

}
