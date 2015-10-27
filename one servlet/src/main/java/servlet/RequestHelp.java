package servlet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import servlet.Commands.*;

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
        ApplicationContext context = new ClassPathXmlApplicationContext("module.xml");
        commands.put("login", (Login)context.getBean("login"));
        commands.put("projects",(Project)context.getBean("project"));
        commands.put("iterations", (Iteration)context.getBean("iteration"));
        commands.put("tasks",(Task)context.getBean("tasks"));

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
