package servlet.DAO;

import servlet.tasks.Task;

import java.util.List;

/**
 * Created by User on 22.10.2015.
 */
public interface TaskDao {
    List<Task> findTasks(int n);


}
