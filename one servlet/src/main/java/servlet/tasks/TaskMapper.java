package servlet.tasks;

import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by User on 29.10.2015.
 */
public class TaskMapper implements  RowMapper{

    public static final String KATEGORY = "t_kategory";
    public static final String DESCRIPTION = "t_description";
    public static final String HOURS = "t_estimatedHours";
    public static final String ID = "it_id";

    public Task mapRow(ResultSet resultSet, int i) throws SQLException {
        Task task = new Task();
        task.setT_kategory(resultSet.getString(KATEGORY));
        task.setT_description(resultSet.getString(DESCRIPTION));
        task.setT_estimatedHours(resultSet.getDate(HOURS));
        task.setIt_id(resultSet.getInt(ID));

        return task;
    }
}
