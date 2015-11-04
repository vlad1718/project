package servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import servlet.comands.LoginCommand;
import servlet.comands.RegistrationCommand;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by User on 24.10.2015.
 */

public class Controller extends HttpServlet {
    public static final String MAIN = "main";
    public static final String LOGIN = "login";
    public static final String LOGIN_JSP = "/login.jsp";
    private RequestHelp rq;
    private static final Logger logger =
            LoggerFactory.getLogger(LoginCommand.class);
    public Controller() {
        super();
    }

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ApplicationContext cont = WebApplicationContextUtils
                .getRequiredWebApplicationContext(getServletContext());
        rq = (RequestHelp) cont.getBean(MAIN);


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
        Command command = rq.getCommand(request);
        logger.debug(command.toString());
        HttpSession session = request.getSession(true);
        session.setAttribute(LOGIN, session.getAttribute(LOGIN) == null ? false : session.getAttribute(LOGIN));
        if (session.getAttribute(LOGIN).equals(true) || command instanceof RegistrationCommand || command instanceof LoginCommand) {
            page = command.execute(request, response);
            RequestDispatcher dispatcher =
                    getServletContext().getRequestDispatcher(page);
            dispatcher.forward(request, response);
        } else response.sendRedirect(LOGIN_JSP);
    }

}
