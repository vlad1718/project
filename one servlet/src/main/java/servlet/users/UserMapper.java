package servlet.users;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by User on 29.10.2015.
 */
public class UserMapper implements RowMapper {

    public static final String USERNAME = "u_username";
    public static final String EMAIL = "u_email";
    public static final String PASSWORD = "u_password";

    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setU_username(resultSet.getString(USERNAME));
        user.setU_email(resultSet.getString(EMAIL));
        user.setU_password(resultSet.getString(PASSWORD));


        return user;
    }
}
