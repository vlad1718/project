package servlet.validator;

import servlet.DAO.IterationDao;
import servlet.converter.DateConverter;
import servlet.exceptions.ValidationException;
import servlet.iterations.Iteration;

/**
 * Created by vl_gr on 04.11.2015.
 */
public class IterationAddValidator extends ValidationCommons {
    private IterationDao iterationDao;

    public void setDateConverter(DateConverter dateConverter) {
        this.dateConverter = dateConverter;
    }

    private DateConverter dateConverter;

    public void setIterationDao(IterationDao iterationDao) {
        this.iterationDao = iterationDao;
    }

    public void validate(String name, String desc, String startDate, String completeDate, String status, int pr_id) throws ValidationException {

        super.validate(name, dateConverter.convert(startDate), dateConverter.convert(completeDate));
        Iteration iteration = new Iteration(name, desc, dateConverter.convert(startDate), dateConverter.convert(completeDate), status, pr_id);
        iterationDao.insert(iteration);
    }
}
