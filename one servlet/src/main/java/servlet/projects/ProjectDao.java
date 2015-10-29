package servlet.projects;

import java.util.List;

/**
 * Created by User on 18.10.2015.
 */
public interface ProjectDao {
    void insert(Projects project);
    List<Projects> findAll();
}
