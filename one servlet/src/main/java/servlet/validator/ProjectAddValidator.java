package servlet.validator;

import servlet.exceptions.ValidationException;
import servlet.projects.Project;
import servlet.projects.ProjectDao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by User on 03.11.2015.
 */
public class ProjectAddValidator {
    private ProjectDao projectDao;

    public void setProjectDao(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    public void validate(String name,String startDate , String completeDate) throws ValidationException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM");
        Date ps = null;
        Date ds = null;
        try {
            ps = sdf.parse(startDate);
            ds = sdf.parse(completeDate);
        } catch (ParseException e) {

        }

        if(name.isEmpty()){
           throw(new ValidationException("you input empty project name"));
       }
        else if(ps.getTime() > ds.getTime()){
            throw (new ValidationException("complete date not to be early start date"));
        }
        else { Project pr = new Project(name, ps, ds);
            projectDao.insert(pr);
        }
    }
}
