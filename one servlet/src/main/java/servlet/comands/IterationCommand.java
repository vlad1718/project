package servlet.comands;

import servlet.Command;
import servlet.iterations.IterationDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * Created by vl_gr on 26.10.2015.
 */
public class IterationCommand implements Command {
    public static final String LIST = "list";
    public static final String LIST_ITER_JSP = "/listIter.jsp";
    private IterationDao it;



    public void setIt(IterationDao it) {
        this.it = it;
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM");
        HttpSession session = request.getSession(true);


        request.setAttribute(LIST, it.findIter((Integer) session.getAttribute("project")));
        page = LIST_ITER_JSP;

        return page;

    }
}


