package servlet.validator;

import servlet.exceptions.ValidationException;
import servlet.projects.Project;
import servlet.DAO.ProjectDao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by User on 03.11.2015.
 */
public class ProjectAddValidator extends ValidationCommons {
    private ProjectDao projectDao;

    public void setProjectDao(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    public void validate(String name, String startDate, String completeDate) throws ValidationException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM");
        Date ps = null;
        Date ds = null;
        try {
            ps = sdf.parse(startDate);
            ds = sdf.parse(completeDate);
        } catch (ParseException e) {

        }
        super.validate(name, ps, ds);
        Project pr = new Project(name, ps, ds);
        projectDao.insert(pr);

    }
}
