package servlet;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * Created by User on 24.10.2015.
 */
public class RequestHelp {
    private static RequestHelp instance = null;

    public HashMap<String, Command> getCommands() {
        return commands;
    }

    public void setCommands(HashMap<String, Command> commands) {
        this.commands = commands;
    }

    private HashMap<String, Command> commands =
            new HashMap<String, Command>();
    private RequestHelp() {

        commands.put("login", new Login());
        commands.put("projects",new Project());
          }
    public Command getCommand(HttpServletRequest request) {

        String action = request.getParameter("command");
        Command command = commands.get(action);
        if (command == null) {
            command = new NoCommand();
        }
        return command;
    }

    public static RequestHelp getInstance() {
        if (instance == null) {
            instance = new RequestHelp();
        }
        return instance;
    }
}
