package management.project.tasks;

import management.project.DAO.TaskDao;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vl_gr on 22.10.2015.
 */
public class TaskDaoImpl implements TaskDao {
    private NamedParameterJdbcTemplate sjt;

    public NamedParameterJdbcTemplate getSjt() {
        return sjt;
    }

    public void setSjt(NamedParameterJdbcTemplate sjt) {
        this.sjt = sjt;
    }


   public List<Task> findTasks(int it_id) {
        String sql = "SELECT * FROM tasks where it_id=:it_id";


       SqlParameterSource namedParameters = new MapSqlParameterSource("it_id", Integer.valueOf(it_id));
       List<Task> task = getSjt().query(sql, namedParameters,new TaskMapper());


        return task;
    }

    public void insert(Task task) {
        String sql = "INSERT INTO tasks " +
                "(t_kategory, t_description, t_estimatedHours, it_id) VALUES (:t_kategory, :t_description, :t_estimatedHours, :it_id)";

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("t_kategory", task.getKategory());
        parameters.put("t_description", task.getDescription());
        parameters.put("t_estimatedHours", task.getEstimatedHours());
        parameters.put("it_id", task.getIterationID());
        getSjt().update(sql, parameters);
    }
}

