package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by User on 23.10.2015.
 */
public interface Command {
    String execute(HttpServletRequest request,
                   HttpServletResponse response)
            throws ServletException, IOException;
}
