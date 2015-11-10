package management.project.tasks;

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

    public Integer getEstimatedHours() {
        return estimatedHours;
    }

    public void setEstimatedHours(int estimatedHours) {
        this.estimatedHours = estimatedHours;
    }

    private String kategory;
    private String description;
    private int estimatedHours;

    public Task() {
    }

    public Task(String kategory, String description, int estimatedHours, int iterationID) {

        this.kategory = kategory;
        this.description = description;
        this.estimatedHours = estimatedHours;
        this.iterationID = iterationID;
    }

    public int getIterationID() {
        return iterationID;
    }

    public void setIterationID(int iterationID) {
        this.iterationID = iterationID;
    }

    private int iterationID;

}