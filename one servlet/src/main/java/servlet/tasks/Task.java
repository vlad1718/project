package servlet.tasks;

import java.util.Date;

/**
 * Created by User on 22.10.2015.
 */
public class Task {
    private int t_id;

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public String getT_kategory() {
        return t_kategory;
    }

    public void setT_kategory(String t_kategory) {
        this.t_kategory = t_kategory;
    }

    public String getT_description() {
        return t_description;
    }

    public void setT_description(String t_description) {
        this.t_description = t_description;
    }

    public Date getT_estimatedHours() {
        return t_estimatedHours;
    }

    public void setT_estimatedHours(Date t_estimatedHours) {
        this.t_estimatedHours = t_estimatedHours;
    }

    public int getIt_id() {
        return it_id;
    }

    public void setIt_id(int it_id) {
        this.it_id = it_id;
    }

    private String t_kategory;
    private String t_description;
    private Date t_estimatedHours;


    private int it_id;

}