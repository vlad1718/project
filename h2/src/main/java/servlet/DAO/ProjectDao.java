package servlet.DAO;

import servlet.projects.Project;

import java.util.List;

/**
 * Created by vl_gr on 18.10.2015.
 */
public interface ProjectDao {
    void insert(Project project);

    List<Project> findAll();

}