package servlet.DAO;

import servlet.users.User;

import java.util.List;

/**
 * Created by User on 24.10.2015.
 */
public interface UserDao {
    List getUser(String log, String pas);

    void insert(User user);
}
