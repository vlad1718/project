package servlet.iterations;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by User on 20.10.2015.
 */
public class IterationDaoImpl implements IterationDao {
    public NamedParameterJdbcTemplate getSjt() {
        return sjt;
    }

    public void setSjt(NamedParameterJdbcTemplate sjt) {
        this.sjt = sjt;
    }

    private NamedParameterJdbcTemplate sjt;
    public void insert(Iterations iter) {
        String sql = "INSERT INTO iterations " +
                "( it_name, it_description, it_startDate, it_endDate, it_status, pr_id) VALUES (:it_name, :it_description, :it_startDate, :it_endDate, :it_status, :pr_id)";


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
                (List<Iterations>) getSjt().query(sql, new IterationMapper());

        return iter;
    }

    public List<Iterations> findIter(int pr_id){
        String sql = "SELECT * FROM iterations where pr_id=:pr_id";

        List<Iterations> iter =
                (List<Iterations>) getSjt().query(sql, new IterationMapper());

        return iter;
    }

    public Iterations findThisIter(int it_id) {
        String sql = "SELECT * FROM iterations where it_id=:it_id";


        SqlParameterSource namedParameters = new MapSqlParameterSource("it_id", Integer.valueOf(it_id));
        Iterations iteration = (Iterations) getSjt().queryForObject(sql, namedParameters, new IterationMapper());
        return iteration;


    }

    public void del(int it_id) {

        String sql = "Delete  FROM iterations where it_id=:it_id";
        String sql1 = "Delete  FROM tasks where it_id=:it_id";

        SqlParameterSource namedParameters = new MapSqlParameterSource("it_id", Integer.valueOf(it_id));
        getSjt().update(sql, namedParameters);
        getSjt().update(sql1, namedParameters);
    }
}
