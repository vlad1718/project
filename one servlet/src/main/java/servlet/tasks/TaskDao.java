package servlet.tasks;

import java.util.List;

/**
 * Created by User on 22.10.2015.
 */
public interface TaskDao {
    List<Tasks> findTasks(int n);


}
