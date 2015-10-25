package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
            Command command = requestH.getCommand(request);
            page = command.execute(request, response);

        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }
}
