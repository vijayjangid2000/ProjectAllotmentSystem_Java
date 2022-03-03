package dbHelper;

public class Member {

   private int uniqueId;
 private   int employeeId;
   private int employeeRole;
 private   int projectId;
   private boolean isActive;



    public int getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(int uniqueId) {
        this.uniqueId = uniqueId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getEmployeeRole() {
        return employeeRole;
    }

    public void setEmployeeRole(int employeeRole) {
        this.employeeRole = employeeRole;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
