package management.project.DAO;

import management.project.users.User;

import java.util.List;

/**
 * Created by vl_gr on 24.10.2015.
 */
public interface UserDao {
    List getUser(String log, String pas);

    void insert(User user);
}
