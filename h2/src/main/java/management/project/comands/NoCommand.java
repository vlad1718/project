package management.project.comands;

import management.project.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by vl_gr on 24.10.2015.
 */
public class NoCommand implements Command {
    public static final String LOGIN_JSP = "/login.jsp";

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = LOGIN_JSP;
        return page;
    }
}
