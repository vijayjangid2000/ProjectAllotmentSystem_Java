package dbHelper;

public class Employee {

  private   int uniqueId;
   private  String name;
   private  String lastName;
   private  String email;
   private  String mobile;
   private  String dateOfBirth;
    private String joiningDate;
 private    int managerId;
  private   int noOfAssignedProject;
 private    int previousExperienceInYears;
    private int domainExpertiseId;
  private   int rankInCompany;
   private String lastModifiedBy;
 private    String lastModifiedOn;
   private  String createdBy;
 private    String createdOn;
 private    boolean isActive;

    public int getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(int uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public int getNoOfAssignedProject() {
        return noOfAssignedProject;
    }

    public void setNoOfAssignedProject(int noOfAssignedProject) {
        this.noOfAssignedProject = noOfAssignedProject;
    }

    public int getPreviousExperienceInYears() {
        return previousExperienceInYears;
    }

    public void setPreviousExperienceInYears(int previousExperienceInYears) {
        this.previousExperienceInYears = previousExperienceInYears;
    }

    public int getDomainExpertiseId() {
        return domainExpertiseId;
    }

    public void setDomainExpertiseId(int domainExpertiseId) {
        this.domainExpertiseId = domainExpertiseId;
    }

    public int getRankInCompany() {
        return rankInCompany;
    }

    public void setRankInCompany(int rankInCompany) {
        this.rankInCompany = rankInCompany;
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
