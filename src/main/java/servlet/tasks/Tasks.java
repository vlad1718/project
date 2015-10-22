package servlet.tasks;

import java.util.Date;

/**
 * Created by User on 22.10.2015.
 */
public class Tasks{
    private int id;
    private String kategory;
    private String description;
    private Date  estimatedHours;

    @Override
    public String toString() {
        return "Tasks{" +
                "id=" + id +
                ", kategory='" + kategory + '\'' +
                ", description='" + description + '\'' +
                ", estimatedHours=" + estimatedHours +
                ", id_it=" + id_it +
                '}';
    }

    private int id_it;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKategory() {
        return kategory;
    }

    public void setKategory(String kategory) {
        this.kategory = kategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEstimatedHours() {
        return estimatedHours;
    }

    public void setEstimatedHours(Date estimatedHours) {
        this.estimatedHours = estimatedHours;
    }

    public int getId_it() {
        return id_it;
    }

    public void setId_it(int id_it) {
        this.id_it = id_it;
    }
}
