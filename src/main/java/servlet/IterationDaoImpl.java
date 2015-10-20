package servlet;

import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by User on 20.10.2015.
 */
public class IterationDaoImpl implements IterationDao {
    public SimpleJdbcTemplate getSjt() {
        return sjt;
    }

    public void setSjt(SimpleJdbcTemplate sjt) {
        this.sjt = sjt;
    }

    private SimpleJdbcTemplate sjt;
    public void insert(Iterations iter) {
        String sql = "INSERT INTO iterations " +
                "(it_id, it_name, it_description, it_startDate, it_endDate, it_status, pr_id) VALUES (0,:it_Name, :it_description, :it_startDate, :it_endDate,, :it_status, :pr_id)";

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("it_name", iter.getIt_name());
        parameters.put("it_description", iter.getIt_description());
        parameters.put("it_startDate", iter.getIt_startDate());
        parameters.put("it_endDate", iter.getIt_endDate());
        parameters.put("it_status", iter.getIt_status());
        parameters.put("pr_id", iter.getPr_id());
        getSjt().update(sql, parameters);
    }
    public List<Iterations> findAll(){

        String sql = "SELECT * FROM iterations";

        List<Iterations> iter =
                getSjt().query(sql,
                        ParameterizedBeanPropertyRowMapper.newInstance(Iterations.class));

        return iter;
    }
}
