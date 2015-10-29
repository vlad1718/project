package servlet.iterations;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by User on 29.10.2015.
 */
public class IterationMapper implements RowMapper {

    public static final String NAME = "it_name";
    public static final String DESCRIPTION = "it_description";
    public static final String START_DATE = "it_startDate";
    public static final String END_DATE = "it_endDate";
    public static final String STATUS = "it_status";
    public static final String ID = "pr_id";

    public Iterations mapRow(ResultSet rs, int rowNum) throws SQLException {
        Iterations iter = new Iterations();
        iter.setIt_name(rs.getString(NAME));
        iter.setIt_description(rs.getString(DESCRIPTION));
        iter.setIt_startDate(rs.getDate(START_DATE));
        iter.setIt_endDate(rs.getDate(END_DATE));
        iter.setIt_status(rs.getString(STATUS));
        iter.setPr_id(rs.getInt(ID));
        return iter;
    }
}
