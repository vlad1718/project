package servlet;

import java.util.List;

/**
 * Created by User on 18.10.2015.
 */
public interface ProjectDao {
    public void insert(Projects project);
    public List<Projects> getAllProjects();
}
