package dbHelper;

public class Milestone {

    private int uniqueId;
    private int projectId;
    private int mileNumber;

    private String title;

    private String description;
    private int timeInHours;
    private int status;
    private int assignedToEmployeeId;
    private int completedByEmployeeId;
    private String lastModifiedBy;
    private String lastModifiedOn;
    private String createdBy;
    private String createdOn;
    private boolean isActive;

    public int getMileNumber() {
        return mileNumber;
    }

    public void setMileNumber(int mileNumber) {
        this.mileNumber = mileNumber;
    }

    public int getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(int uniqueId) {
        this.uniqueId = uniqueId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTimeInHours() {
        return timeInHours;
    }

    public void setTimeInHours(int timeInHours) {
        this.timeInHours = timeInHours;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getAssignedToEmployeeId() {
        return assignedToEmployeeId;
    }

    public void setAssignedToEmployeeId(int assignedToEmployeeId) {
        this.assignedToEmployeeId = assignedToEmployeeId;
    }

    public int getCompletedByEmployeeId() {
        return completedByEmployeeId;
    }

    public void setCompletedByEmployeeId(int completedByEmployeeId) {
        this.completedByEmployeeId = completedByEmployeeId;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public String getLastModifiedOn() {
        return lastModifiedOn;
    }

    public void setLastModifiedOn(String lastModifiedOn) {
        this.lastModifiedOn = lastModifiedOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
