package servlet.tasks;

import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import java.util.List;

/**
 * Created by User on 22.10.2015.
 */
public class TaskDaoImpl implements TaskDao {
    private SimpleJdbcTemplate sjt;
    public SimpleJdbcTemplate getSjt() {
        return sjt;
    }

    public void setSjt(SimpleJdbcTemplate sjt) {
        this.sjt = sjt;
    }


    public List<Tasks> findTasks(int n){
        String sql = "SELECT * FROM tasks where it_id='" + n +"'";

        List<Tasks> task =
                getSjt().query(sql,
                        ParameterizedBeanPropertyRowMapper.newInstance(Tasks.class));

        return task;
    }
}
