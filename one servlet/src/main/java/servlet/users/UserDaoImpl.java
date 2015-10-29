package servlet.users;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by User on 24.10.2015.
 */
public class UserDaoImpl implements UserDao {
    private NamedParameterJdbcTemplate sjt;

    public NamedParameterJdbcTemplate getSjt() {
        return sjt;
    }

    public void setSjt(NamedParameterJdbcTemplate sjt) {
        this.sjt = sjt;
    }

    public Users search(String u_username,String u_password) {
        String sql = "select *from user where u_username=:u_username and u_password=u_password";

        Map<String, Object> argMap = new HashMap<String, Object>();
        argMap.put("u_username", u_username);
        argMap.put("u_password", u_password);
        Users user = (Users) getSjt().queryForObject(sql, argMap, new UserMapper());
        return user;
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
