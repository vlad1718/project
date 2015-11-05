package servlet;

import servlet.comands.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by vl_gr on 24.10.2015.
 */
public class RequestHelp {
    public Map<String, Command> commands =
            new HashMap<String, Command>();

    public RequestHelp(Map map) {
        this.commands = (Map<String, Command>) map;
    }

    public Command getCommand(HttpServletRequest request) {
        String path = request.getRequestURI();

        Command command = commands.get(path);
        if (command == null) {
            command = new NoCommand();
        }
        return command;
    }
}
