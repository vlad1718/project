package servlet.projects;

import java.util.Date;

/**
 * Created by User on 18.10.2015.
 */
public class Projects {
    private int idProject;
    private String projectName;
    private Date startDate;
    private Date completeDate;

    Projects(){

    }
    public Projects(int idProject, String projectName, Date startDate, Date completeDate) {
        this.idProject = idProject;
        this.projectName = projectName;
        this.startDate = startDate;
        this.completeDate = completeDate;
    }

    @Override
    public String toString() {
        return "Projects{" +
                "idProject=" + idProject +
                ", projectName='" + projectName + '\'' +
                ", startDate=" + startDate +
                ", completeDate=" + completeDate +
                '}';
    }

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(Date completeDate) {
        this.completeDate = completeDate;
    }
}
