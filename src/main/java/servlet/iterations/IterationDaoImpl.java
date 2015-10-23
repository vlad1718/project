package servlet.iterations;

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
                "(it_id, it_name, it_description, it_startDate, it_endDate, it_status, pr_id) VALUES (0,:it_name, :it_description, :it_startDate, :it_endDate, :it_status, :pr_id)";

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

    public List<Iterations> findIter(int n){
        String sql = "SELECT * FROM iterations where pr_id='" + n +"'";

        List<Iterations> iter =
                getSjt().query(sql,
                        ParameterizedBeanPropertyRowMapper.newInstance(Iterations.class));

        return iter;
    }

    public List findThisIter(int n) {
        String sql = "SELECT * FROM iterations where it_id='" + n +"'";

        List<Iterations> iter =
                getSjt().query(sql,
                        ParameterizedBeanPropertyRowMapper.newInstance(Iterations.class));

        return iter;
    }

    public void del(int list) {

        String sql = "Delete  FROM iterations where it_id=?";
        String sql1 = "Delete  FROM tasks where it_id=?";

        getSjt().update(sql,list);
        getSjt().update(sql1,list);
    }
}
