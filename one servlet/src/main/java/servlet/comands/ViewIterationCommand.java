package servlet.comands;

import servlet.Command;
import servlet.iterations.IterationDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by User on 30.10.2015.
 */
public class ViewIterationCommand implements Command {
    public static final String ITER = "iter";
    public static final String IT = "it";
    public static final String LIST = "list";
    public static final String DEL = "del";
    public static final String ITERATIONS = "/iterations";
    public static final String VIEW_JSP = "/view.jsp";
    private IterationDao it;

    public void setIt(IterationDao it) {
        this.it = it;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String st = request.getParameter(ITER);
        HttpSession session = request.getSession(true);
        String page = null;
        if (st != null) {

            session.setAttribute(IT, Integer.parseInt(st));
        }
        request.setAttribute(LIST, it.findThisIter((Integer) session.getAttribute(IT)));

        String str = request.getParameter(DEL);
        if (str != null) {

            it.del((Integer) session.getAttribute(IT));
            page = ITERATIONS;
        } else page = VIEW_JSP;


           return page;
    }
}
