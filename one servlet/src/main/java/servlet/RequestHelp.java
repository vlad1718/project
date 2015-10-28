package servlet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import servlet.Commands.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by User on 24.10.2015.
 */
public class RequestHelp {

    private static RequestHelp instance = null;



    private static HashMap<String, Command> commands =
            new HashMap<String, Command>();
    private RequestHelp(Map map) {
           this.commands = (HashMap<String, Command>) map;
          }
    public Command getCommand(HttpServletRequest request) {
        String path = request.getRequestURI();

        Command command = commands.get(path);
        if (command == null) {
            command = new NoCommand();
        }
        return command;
    }

    public static RequestHelp getInstance() {
        if (instance == null) {
            instance = new RequestHelp(commands);
        }
        return instance;
    }


}
