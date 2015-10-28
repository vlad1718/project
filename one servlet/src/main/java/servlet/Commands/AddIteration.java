package servlet.Commands;

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
 * Created by User on 28.10.2015.
 */
public class AddIteration implements Command {
    private IterationDaoImpl it;

    public IterationDaoImpl getIt() {
        return it;
    }

    public void setIt(IterationDaoImpl it) {
        this.it = it;
    }
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM");
        HttpSession session = request.getSession(true);
        String page = "/newIter.jsp";

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

            page="/iterations";
        }
        return page;
    }
}
