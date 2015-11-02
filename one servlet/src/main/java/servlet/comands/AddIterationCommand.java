package servlet.comands;

import servlet.Command;
import servlet.iterations.Iteration;
import servlet.iterations.IterationDao;

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
public class AddIterationCommand implements Command {
    public static final String DESCRIPTION = "Description";
    public static final String START_DATE = "StartDate";
    public static final String END_DATE = "endDate";
    public static final String STATUS = "status";
    public static final String PROJECT = "project";
    public static final String OK = "Ok";
    public static final String ITERATIONS = "/iterations";
    public static final String NAME_ITERATION = "NameIteration";
    public static final String ACT = "act";
    private IterationDao it;
    public void setIt(IterationDao it) {
        this.it = it;
    }
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM");
        HttpSession session = request.getSession(true);
        String page = "/newIter.jsp";

        String act = request.getParameter(ACT);
        if (act != null) {
            String name = request.getParameter(NAME_ITERATION);
            if (name != null) {

                String desc = request.getParameter(DESCRIPTION);
                String startDate = request.getParameter(START_DATE);
                String completeDate = request.getParameter(END_DATE);
                String status = request.getParameter(STATUS);
                int pr_id = (Integer) session.getAttribute(PROJECT);

                Date ps = null;
                Date ds = null;
                try {
                    ps = sdf.parse(startDate);
                    ds = sdf.parse(completeDate);
                } catch (ParseException e) {

                }
                Iteration pr = new Iteration(name, desc, ps, ds, status, pr_id);
                if (act.equals(OK)) {
                    it.insert(pr);
                }
            }

            page= ITERATIONS;
        }
        return page;
    }
}
