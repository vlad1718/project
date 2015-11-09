package management.project.iterations;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by vl_gr on 29.10.2015.
 */
public class IterationMapper implements RowMapper<Iteration> {

    public static final String NAME = "it_name";
    public static final String DESCRIPTION = "it_description";
    public static final String START_DATE = "it_startDate";
    public static final String END_DATE = "it_endDate";
    public static final String STATUS = "it_status";
    public static final String ID = "pr_id";
    public static final String IT_ID = "it_id";

    public Iteration mapRow(ResultSet rs, int rowNum) throws SQLException {

        Iteration iter = new Iteration();

        iter.setId(rs.getInt(IT_ID));
        iter.setName(rs.getString(NAME));
        iter.setDescription(rs.getString(DESCRIPTION));
        iter.setStartDate(rs.getDate(START_DATE));
        iter.setEndDate(rs.getDate(END_DATE));
        iter.setStatus(rs.getString(STATUS));
        iter.setProjectId(rs.getInt(ID));
        return iter;


    }
}
