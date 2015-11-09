package management.project.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by vl_gr on 05.11.2015.
 */
public class DateConverter {
    private Date ds;

    public static final String YYYY_DD_MM = "yyyy-MM-dd";

    public Date convert(String Date) {
        SimpleDateFormat sdf = new SimpleDateFormat(YYYY_DD_MM);
        try {
            ds = sdf.parse(Date);
        } catch (ParseException e) {

        }
        return ds;
    }
}
