package dbHelper;

public class Project {

    private int uniqueId;
    private String title;
    private String name;
    private String description;
    private String deadLine;
    private String finishedOn;
    private boolean isBeforeDeadline;
    private String createdOn;
    private int numberOfEmployeeRequired;
    private int numberOfEmployeeWorking;
    private int managerId;
    private int minimumExperience;
    private int numberOfExperienced;
    private int totalMilestones;
    private int domainExpert;
    private int clientId;
    private String lastModifiedBy;
    private String lastModifiedOn;
    private String createdBy;
    private boolean isActive;


    public Project(String title, String name, String description, String deadLine,
                   String finishedOn, boolean isBeforeDeadline,
                   int numberOfEmployeeRequired, int numberOfEmployeeWorking,
                   int managerId, int minimumExperience, int numberOfExperienced,
                   int totalMilestones, int domainExpert,
                   int clientId, String lastModifiedBy, String lastModifiedOn,
                   String createdBy, String createdOn, boolean isActive) {
        this.title = title;
        this.name = name;
        this.description = description;
        this.deadLine = deadLine;
        this.finishedOn = finishedOn;
        this.isBeforeDeadline = isBeforeDeadline;
        this.createdOn = createdOn;
        this.numberOfEmployeeRequired = numberOfEmployeeRequired;
        this.numberOfEmployeeWorking = numberOfEmployeeWorking;
        this.managerId = managerId;
        this.minimumExperience = minimumExperience;
        this.numberOfExperienced = numberOfExperienced;
        this.totalMilestones = totalMilestones;
        this.domainExpert = domainExpert;
        this.clientId = clientId;
        this.lastModifiedBy = lastModifiedBy;
        this.lastModifiedOn = lastModifiedOn;
        this.createdBy = createdBy;
        this.isActive = isActive;
    }

    public int getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(int uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(String deadLine) {
        this.deadLine = deadLine;
    }

    public String getFinishedOn() {
        return finishedOn;
    }

    public void setFinishedOn(String finishedOn) {
        this.finishedOn = finishedOn;
    }

    public boolean isBeforeDeadline() {
        return isBeforeDeadline;
    }

    public void setBeforeDeadline(boolean beforeDeadline) {
        isBeforeDeadline = beforeDeadline;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public int getNumberOfEmployeeRequired() {
        return numberOfEmployeeRequired;
    }

    public void setNumberOfEmployeeRequired(int numberOfEmployeeRequired) {
        this.numberOfEmployeeRequired = numberOfEmployeeRequired;
    }

    public int getNumberOfEmployeeWorking() {
        return numberOfEmployeeWorking;
    }

    public void setNumberOfEmployeeWorking(int numberOfEmployeeWorking) {
        this.numberOfEmployeeWorking = numberOfEmployeeWorking;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public int getMinimumExperience() {
        return minimumExperience;
    }

    public void setMinimumExperience(int minimumExperience) {
        this.minimumExperience = minimumExperience;
    }

    public int getNumberOfExperienced() {
        return numberOfExperienced;
    }

    public void setNumberOfExperienced(int numberOfExperienced) {
        this.numberOfExperienced = numberOfExperienced;
    }


    public int getTotalMilestones() {
        return totalMilestones;
    }

    public void setTotalMilestones(int totalMilestones) {
        this.totalMilestones = totalMilestones;
    }

    public int getDomainExpert() {
        return domainExpert;
    }

    public void setDomainExpert(int domainExpert) {
        this.domainExpert = domainExpert;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
