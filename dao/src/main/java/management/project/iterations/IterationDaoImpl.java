package management.project.iterations;

import management.project.DAO.IterationDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vl_gr on 20.10.2015.
 */
public class IterationDaoImpl implements IterationDao {
    public NamedParameterJdbcTemplate getSjt() {
        return sjt;
    }

    public void setSjt(NamedParameterJdbcTemplate sjt) {
        this.sjt = sjt;
    }

    private NamedParameterJdbcTemplate sjt;

    public void insert(Iteration iter) {
        String sql = "INSERT INTO iterations " +
                "(it_name, it_description, it_startDate, it_endDate, it_status, pr_id) VALUES (:it_name, :it_description, :it_startDate, :it_endDate, :it_status, :pr_id)";

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("it_name", iter.getName());
        parameters.put("it_description", iter.getDescription());
        parameters.put("it_startDate", iter.getStartDate());
        parameters.put("it_endDate", iter.getEndDate());
        parameters.put("it_status", iter.getStatus());
        parameters.put("pr_id", iter.getProjectId());
        getSjt().update(sql, parameters);
    }

    public List<Iteration> findAll() {

        String sql = "SELECT * FROM iterations";

        List<Iteration> iterations =
                getSjt().query(sql, BeanPropertyRowMapper.newInstance(Iteration.class));

        return iterations;
    }

    public List findIter(int pr_id) {
        String sql = "SELECT * FROM iterations where pr_id=:pr_id";

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("pr_id",pr_id);
        List<Iteration> iteration = getSjt().query(sql, namedParameters, new IterationMapper());
        return iteration;
    }

    public List findThisIter(int it_id) {
        String sql = "SELECT * FROM iterations where it_id=:it_id";

        SqlParameterSource namedParameters = new MapSqlParameterSource("it_id", Integer.valueOf(it_id));
        List<Iteration> iteration = getSjt().query(sql, namedParameters, BeanPropertyRowMapper.newInstance(Iteration.class));
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