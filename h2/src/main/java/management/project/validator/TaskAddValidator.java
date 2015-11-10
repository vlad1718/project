package management.project.validator;

import management.project.DAO.TaskDao;
import management.project.exceptions.ValidationException;
import management.project.tasks.Task;

/**
 * Created by User on 10.11.2015.
 */
public class TaskAddValidator {
    public void setTaskDao(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    private TaskDao taskDao;

    public void vaildate(String kategory, String description, String estimatedHours, int it_id) throws ValidationException {
        if (description.isEmpty()) {
            throw new ValidationException("Description can be specified");
        }
        else {
            Task task = new Task(kategory,description,Integer.parseInt(estimatedHours),it_id);
            taskDao.insert(task);
        }
    }
}
