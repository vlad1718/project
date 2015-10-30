package servlet.projects;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by User on 29.10.2015.
 */
public class ProjectMapper implements RowMapper {

    public static final String NAME = "projectName";
    public static final String DATE = "startDate";
    public static final String COMPLETE_DATE = "completeDate";
    public static final String ID = "idProject";

    public Projects mapRow(ResultSet resultSet, int i) throws SQLException {
        Projects project = new Projects();
        project.setIdProject(resultSet.getInt(ID));
        project.setProjectName(resultSet.getString(NAME));
        project.setStartDate(resultSet.getDate(DATE));
        project.setCompleteDate(resultSet.getDate(COMPLETE_DATE));


        return project;
    }
}
