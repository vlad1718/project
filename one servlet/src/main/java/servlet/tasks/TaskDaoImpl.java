package servlet.tasks;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

/**
 * Created by User on 22.10.2015.
 */
public class TaskDaoImpl implements TaskDao {
    private NamedParameterJdbcTemplate sjt;
    public NamedParameterJdbcTemplate getSjt() {
        return sjt;
    }

    public void setSjt(NamedParameterJdbcTemplate sjt) {
        this.sjt = sjt;
    }


    public Tasks findTasks(int it_id){
        String sql = "SELECT * FROM tasks where it_id=:it_id";

        SqlParameterSource namedParameters = new MapSqlParameterSource("it_id", Integer.valueOf(it_id));
        Tasks task = (Tasks) getSjt().queryForObject(sql, namedParameters, new TaskMapper());
        return task;
    }
}
