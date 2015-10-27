package servlet.users;

import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by User on 24.10.2015.
 */
public class UserDaoImpl implements UserDao {
    private SimpleJdbcTemplate sjt;

    public SimpleJdbcTemplate getSjt() {
        return sjt;
    }

    public void setSjt(SimpleJdbcTemplate sjt) {
        this.sjt = sjt;
    }

    public List search(String log,String pas) {
        String sql = "select *from user where u_username=? and u_password=?";

        List<Users> users =
                getSjt().query(sql,
                        ParameterizedBeanPropertyRowMapper.newInstance(Users.class),log,pas);

        return users;
    }
    public void insert(Users user) {

        String sql = "INSERT INTO user " +
                "(u_username, u_email,u_password) VALUES (:u_username, :u_email, :u_password)";

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("u_username", user.getU_username());
        parameters.put("u_email", user.getU_email());
        parameters.put("u_password", user.getU_password());
        getSjt().update(sql, parameters);
    }



}
