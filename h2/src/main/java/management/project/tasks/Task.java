package management.project.tasks;

import java.util.Date;

/**
 * Created by vl_gr on 22.10.2015.
 */
public class Task {
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    private String kategory;
    private String description;
    private Date estimatedHours;


    private int projectId;

}