package servlet.projects;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import servlet.DAO.ProjectDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by vl_gr on 18.10.2015.
 */
public class ProjectDaoImpl implements ProjectDao {


    public NamedParameterJdbcTemplate getSjt() {
        return sjt;
    }

    private NamedParameterJdbcTemplate sjt;


    public void setDs(NamedParameterJdbcTemplate ds) {

        this.sjt = ds;
    }

    public void insert(Project project) {

        String sql = "INSERT INTO projects " +
                "( projectName, startDate,completeDate) VALUES (:projectName, :startDate, :completeDate)";

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("projectName", project.getProjectName());
        parameters.put("startDate", project.getStartDate());
        parameters.put("completeDate", project.getCompleteDate());
        getSjt().update(sql, parameters);
    }

    public List<Project> findAll() {

        String sql = "SELECT * FROM projects";

        List<Project> projects =
                getSjt().query(sql, BeanPropertyRowMapper.newInstance(Project.class));

        return projects;
    }


}
