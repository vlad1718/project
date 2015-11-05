package servlet.validator;

import servlet.DAO.ProjectDao;
import servlet.converter.DateConverter;
import servlet.exceptions.ValidationException;
import servlet.projects.Project;

/**
 * Created by vl_gr on 03.11.2015.
 */
public class ProjectAddValidator extends ValidationCommons {
    private ProjectDao projectDao;


    public void setDateConverter(DateConverter dateConverter) {
        this.dateConverter = dateConverter;
    }

    private DateConverter dateConverter;

    public void setProjectDao(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    public void validate(String name, String startDate, String completeDate) throws ValidationException {
        super.validate(name,  dateConverter.convert(startDate),   dateConverter.convert(completeDate));
        Project pr = new Project(name,   dateConverter.convert(startDate),   dateConverter.convert(completeDate));
        projectDao.insert(pr);

    }
}
