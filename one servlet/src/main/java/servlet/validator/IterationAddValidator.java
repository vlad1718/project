package servlet.validator;

import servlet.DAO.IterationDao;
import servlet.exceptions.ValidationException;
import servlet.iterations.Iteration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by User on 04.11.2015.
 */
public class IterationAddValidator extends ValidationCommons {
    private IterationDao iterationDao;

    public void setIterationDao(IterationDao iterationDao) {
        this.iterationDao = iterationDao;
    }

    public void validate(String name, String desc, String startDate, String completeDate, String status, int pr_id) throws ValidationException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM");
        Date ps = null;
        Date ds = null;
        try {
            ps = sdf.parse(startDate);
            ds = sdf.parse(completeDate);
        } catch (ParseException e) {

        }
        super.validate(name, ps, ds);
        Iteration iteration = new Iteration(name, desc, ps, ds, status, pr_id);
        iterationDao.insert(iteration);
    }
}
