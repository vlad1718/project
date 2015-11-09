package management.project.users;

import management.project.DAO.UserDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vl_gr on 24.10.2015.
 */
public class UserDaoImpl implements UserDao {
    private NamedParameterJdbcTemplate sjt;

    public NamedParameterJdbcTemplate getSjt() {
        return sjt;
    }

    public void setSjt(NamedParameterJdbcTemplate sjt) {
        this.sjt = sjt;
    }

    public List getUser(String u_username, String u_password) {
        String sql = "select *from user where u_username=:u_username and u_password=:u_password";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("u_username",u_username);
        namedParameters.addValue("u_password",u_password);
        List<User> results = getSjt().query(sql, namedParameters, new BeanPropertyRowMapper<User>(User.class));

        return results;
    }

    public void insert(User user) {

        String sql = "INSERT INTO user " +
                "(u_username, u_email,u_password) VALUES (:u_username, :u_email, :u_password)";

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("u_username", user.getUsername());
        parameters.put("u_email",user.getEmail());
        parameters.put("u_password", user.getPassword());
        getSjt().update(sql, parameters);
    }


}
