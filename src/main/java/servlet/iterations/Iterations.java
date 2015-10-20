package servlet.iterations;

import java.util.Date;

/**
 * Created by User on 19.10.2015.
 */
public class Iterations {
    private int it_id;
    private String it_name;

    private String it_description;
    private Date it_startDate;
    private Date it_endDate;
    private String it_status;

    public Iterations() {
    }

    public Iterations(int it_id, String it_name, String it_description, Date it_startDate, Date it_endDate, String it_status, int pr_id) {
        this.it_id = it_id;
        this.it_name = it_name;
        this.it_description = it_description;
        this.it_startDate = it_startDate;
        this.it_endDate = it_endDate;
        this.it_status = it_status;
        this.pr_id = pr_id;
    }

    public int getPr_id() {
        return pr_id;
    }

    public void setPr_id(int pr_id) {
        this.pr_id = pr_id;
    }

    private int pr_id;
    @Override
    public String toString() {
        return "Iterations{" +
                "it_id=" + it_id +
                ", it_name='" + it_name + '\'' +

                ", it_description='" + it_description + '\'' +
                ", it_startDate=" + it_startDate +
                ", it_endDate=" + it_endDate +
                ", it_status='" + it_status + '\'' +
                '}';
    }

    public int getIt_id() {
        return it_id;
    }

    public void setIt_id(int it_id) {
        this.it_id = it_id;
    }

    public String getIt_name() {
        return it_name;
    }

    public void setIt_name(String it_name) {
        this.it_name = it_name;
    }




    public String getIt_description() {
        return it_description;
    }

    public void setIt_description(String it_description) {
        this.it_description = it_description;
    }

    public Date getIt_startDate() {
        return it_startDate;
    }

    public void setIt_startDate(Date it_startDate) {
        this.it_startDate = it_startDate;
    }

    public Date getIt_endDate() {
        return it_endDate;
    }

    public void setIt_endDate(Date it_endDate) {
        this.it_endDate = it_endDate;
    }

    public String getIt_status() {
        return it_status;
    }

    public void setIt_status(String it_status) {
        this.it_status = it_status;
    }
}
