package servlet.users;

import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

import java.util.List;

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
        String sql = "select *from user where u_username='"+log+"'"+"and u_password='"+pas+"'";
        List<Users> users =
                getSjt().query(sql,
                        ParameterizedBeanPropertyRowMapper.newInstance(Users.class));

        return users;
    }


}
