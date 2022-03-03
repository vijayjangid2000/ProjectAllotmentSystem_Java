package dbHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHelper {

    public static void main(String[] args) {

    }

    public static void createAllTablesAndDb() {

        try (Connection conn = DriverManager.getConnection(DbQueries.DB_URL,
                DbQueries.DB_USER, DbQueries.DB_PASSWORD);
             Statement stmt = conn.createStatement();
        ) {
            stmt.executeUpdate(DbQueries.CREATE_DATABASE);
            stmt.executeUpdate("USE " + DbQueries.DB_NAME);

            stmt.executeUpdate(DbQueries.CREATE_TABLE_AUTHENTICATE);
            stmt.executeUpdate(DbQueries.CREATE_TABLE_CLIENT);
            stmt.executeUpdate(DbQueries.CREATE_TABLE_MEMBER);
            stmt.executeUpdate(DbQueries.CREATE_TABLE_MILESTONE);
            stmt.executeUpdate(DbQueries.CREATE_TABLE_PROJECT);
            stmt.executeUpdate(DbQueries.CREATE_TABLE_EMPLOYEE);

            System.out.println("DB and all tables created successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void addNewRowToProjectTable(Project project) {
        String insertProject = "Insert into project values ( " +
                project.getUniqueId() + " ,  " + project.getTitle() + " ,  " +
                project.getDescription() + " ,  " + project.getDeadLine() + " ,  " +
                project.getFinishedOn() + " ,  " + project.isBeforeDeadline() + " ,  " +
                project.getNumberOfEmployeeRequired() + " ,  " + project.getNumberOfEmployeeWorking() + " ,  " +
                project.getManagerId() + " ,  " + project.getMinimumExperience()
                + " ,  " + project.getMinimumExperience() + " ,  " + project.getNumberOfExperienced()
                + " ,  " + project.getTotalMilestones() + " ,  " + project.getDomainExpert() + " ,  " +
                project.getClientId() + " ,  " + project.getLastModifiedBy() + " ,  " +
                project.getLastModifiedOn() + " ,  " + project.getCreatedBy() + " ,  " +
                project.getCreatedOn() + " ,  " + project.isActive() +
                ");";

        // pass into statement
    }

    public static void addNewRowToEmployeeTable(Employee employee) {
        String insertEmployee = " Insert into employee values ( " +
                employee.getUniqueId() + " ,  " + employee.getFirstName() + " ,  " +
                employee.getLastName() + " ,  " + employee.getJoiningDate() + " ,  " +
                employee.getEmail() + " ,  " + employee.getMobile() + " ,  " +
                employee.getDateOfBirth() + " ,  " + employee.getManagerId() + " ,  " +
                employee.getNoOfAssignedProject() + " ,  " + employee.getRankInCompany() + " ,  " +
                employee.getPreviousExperienceInYears() + " ,  " + employee.getDomainExpertiseId() + " ,  " +
                employee.getLastModifiedBy() + " ,  " + employee.getLastModifiedOn() + " ,  " +
                employee.getCreatedBy() + " ,  " + employee.getCreatedBy()
                + " ,  " + employee.isActive()
                + ");";
    }

    public static void addNewRowToMemberTable(Member member) {
        String insertMember = " Insert into member values ( " +
                member.getUniqueId() + " ,  " + member.getProjectId() + " ,  " +
                member.getEmployeeId() + " ,  " + member.getEmployeeRole() + " ,  " +
                member.isActive()
                + ");";
    }

    public static void addNewRowToClientTable(Client client) {
        String insertClient = " Insert into client values ( " +
                client.getUniqueId() + " ,  " + client.getFirstName() + " ,  " +
                client.getLastName() + " ,  " + client.getCompanyName() + " ,  " +
                client.getLocation() + " ,  " + client.getCompanyEmail() + " ,  " +
                client.getMobile() + " ,  " + client.getEmail() + " ,  " +
                client.getLastModifiedBy() + " ,  " + client.getLastModifiedOn() + " ,  " +
                client.getCreatedBy() + " ,  " + client.getCreatedOn() + " ,  " +
                client.isActive()
                + ");";
    }

    public static void addNewRowToAuthenticateTable(Authenticate authenticate) {
        String insertAuthenticate = " Insert into authenticate values ( " +
                authenticate.getUniqueId() + " ,  " + authenticate.getUserEmail() + " ,  " +
                authenticate.getPassword() + " ,  " + authenticate.getLastModifiedBy() + " ,  " +
                authenticate.getLastModifiedOn() + " ,  " + authenticate.getCreatedBy() + " ,  " +
                authenticate.getCreatedOn() + " ,  " + authenticate.isActive()
                + ");";
    }

    public static void addNewRowToMilestoneTable(Milestone milestone) {
        String insertMilestone = " Insert into milestone values ( " +
                milestone.getUniqueId() + " ,  " +
                milestone.getMileNumber() + " ,  " + milestone.getProjectId() + " ,  " +
                milestone.getTitle() + " ,  " + milestone.getDescription() + " ,  " +
                milestone.getTimeInHours() + " ,  " + milestone.getStatus() + " ,  " +
                milestone.getAssignedToEmployeeId() + " ,  " + milestone.getCompletedByEmployeeId() + " ,  " +
                milestone.getLastModifiedBy() + " ,  " + milestone.getLastModifiedOn() + " ,  " +
                milestone.getCreatedBy() + " ,  " + milestone.getCreatedOn() + " ,  " +
                milestone.isActive()
                + ");";
    }

}
