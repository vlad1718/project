package servlet;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;


import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by User on 18.10.2015.
 */
public class ProjectDaoImpl implements ProjectDao {
    private DataSource ds;

    public SimpleJdbcTemplate getSjt() {
        return sjt;
    }

    private SimpleJdbcTemplate sjt;


    public DataSource getDs() {
        return ds;
    }

    public void setDs(DataSource ds) {
        this.ds = ds;
        sjt = new SimpleJdbcTemplate(ds);
    }

    public void insert(Projects project) {

        String sql = "INSERT INTO projects " +
                "(idProject, projectName, startDate,completeDate) VALUES (0,:projectName, :startDate, :completeDate)";

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("projectName", project.getProjectName());
        parameters.put("startDate", project.getStartDate());
        parameters.put("completeDate", project.getCompleteDate());
        getSjt().update(sql, parameters);
    }

    public List<Projects> findAll(){

        String sql = "SELECT * FROM projects";

        List<Projects> projects =
                getSjt().query(sql,
                        ParameterizedBeanPropertyRowMapper.newInstance(Projects.class));

        return projects;
    }



}
