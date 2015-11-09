package management.project.tasks;

import management.project.DAO.TaskDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.util.List;

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
       List<Task> task = getSjt().query(sql, namedParameters, BeanPropertyRowMapper.newInstance(Task.class));


        return task;
    }
}

