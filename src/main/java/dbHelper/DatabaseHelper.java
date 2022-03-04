package dbHelper;

import java.sql.*;

public class DatabaseHelper {

    static DatabaseHelper databaseHelper;
    private static Connection connection;

    public DatabaseHelper() {
        try {
            connection = DriverManager.getConnection(DbQueries.DB_URL,
                    DbQueries.DB_USER, DbQueries.DB_PASSWORD);
            Statement statement = connection.createStatement();
            statement.executeUpdate("USE " + DbQueries.DB_NAME);
            statement.close();
            System.out.println("DB Connected.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Date date = new Date(System.currentTimeMillis());

        Project project = new Project("apple", "prjectName", "description", date.toString(), date.toString(),
                true, 5, 5,
                1, 4, 1, 1, 1,
                1, "vijay", date.toString(), "vijay", date.toString(), true
        );
        try {
            connection = DriverManager.getConnection(DbQueries.DB_URL,
                    DbQueries.DB_USER, DbQueries.DB_PASSWORD);
            Statement statement = connection.createStatement();
            statement.executeUpdate("USE " + DbQueries.DB_NAME);
            statement.close();
            System.out.println("DB Connected.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        addNewRowToProjectTable(project);
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

        String insertProject = DbQueries.INSERT_INTO_PROJECT;
        try {
            PreparedStatement preStmt = connection.prepareStatement(insertProject);
            int c = 1;
            preStmt.setString(c++, project.getTitle());
            preStmt.setString(c++, project.getName());
            preStmt.setString(c++, project.getDescription());

            preStmt.setDate(c++, Date.valueOf(project.getDeadLine()));
            preStmt.setDate(c++, Date.valueOf(project.getFinishedOn()));
            preStmt.setBoolean(c++, project.isBeforeDeadline());

            preStmt.setInt(c++, project.getNumberOfEmployeeRequired());
            preStmt.setInt(c++, project.getNumberOfEmployeeWorking());
            preStmt.setInt(c++, project.getManagerId());
            preStmt.setInt(c++, project.getMinimumExperience());
            preStmt.setInt(c++, project.getNumberOfExperienced());
            preStmt.setInt(c++, project.getTotalMilestones());
            preStmt.setInt(c++, project.getDomainExpert());
            preStmt.setInt(c++, project.getClientId());

            preStmt.setString(c++, project.getLastModifiedBy());
            preStmt.setDate(c++, Date.valueOf(project.getLastModifiedOn()));
            preStmt.setString(c++, project.getCreatedBy());
            preStmt.setDate(c++, Date.valueOf(project.getCreatedOn()));
            preStmt.setBoolean(c, project.isActive());

            preStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Query: " + insertProject);
    }

    public static void addNewRowToEmployeeTable(Employee employee) {
        String insertEmployee = DbQueries.INSERT_INTO_EMPLOYEE;
        try {
            PreparedStatement preStmt = connection.prepareStatement(insertEmployee);
            int c = 1;

            preStmt.setString(c++, employee.getName());

            preStmt.setDate(c++, Date.valueOf(employee.getJoiningDate()));
            preStmt.setString(c++, employee.getEmail());
            preStmt.setString(c++, employee.getMobile());

            preStmt.setDate(c++, Date.valueOf(employee.getDateOfBirth()));

            preStmt.setInt(c++, employee.getManagerId());
            preStmt.setInt(c++, employee.getNoOfAssignedProject());
            preStmt.setInt(c++, employee.getRankInCompany());
            preStmt.setInt(c++, employee.getPreviousExperienceInYears());
            preStmt.setInt(c++, employee.getDomainExpertiseId());

            preStmt.setString(c++, employee.getLastModifiedBy());
            preStmt.setDate(c++, Date.valueOf(employee.getLastModifiedOn()));
            preStmt.setString(c++, employee.getCreatedBy());
            preStmt.setDate(c++, Date.valueOf(employee.getCreatedOn()));
            preStmt.setBoolean(c, employee.isActive());

            preStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Query: " + insertEmployee);
    }

    public static void addNewRowToMemberTable(Member member) {

        String insertMember = DbQueries.INSERT_INTO_MEMBER;
        try {
            PreparedStatement preStmt = connection.prepareStatement(insertMember);
            int c = 1;
            preStmt.setInt(c++, member.getProjectId());
            preStmt.setInt(c++, member.getEmployeeId());
            preStmt.setInt(c++, member.getEmployeeRole());

            preStmt.setBoolean(c, member.isActive());
            preStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Query: " + insertMember);

    }

    public static void addNewRowToClientTable(Client client) {

        String insertAuthenticate = DbQueries.INSERT_INTO_CLIENT;
        try {
            PreparedStatement preStmt = connection.prepareStatement(insertAuthenticate);
            int c = 1;
            preStmt.setString(c++, client.getFirstName());
            preStmt.setString(c++, client.getLastName());
            preStmt.setString(c++, client.getCompanyName());
            preStmt.setString(c++, client.getLocation());
            preStmt.setString(c++, client.getCompanyEmail());
            preStmt.setString(c++, client.getMobile());
            preStmt.setString(c++, client.getEmail());

            preStmt.setString(c++, client.getLastModifiedBy());
            preStmt.setDate(c++, Date.valueOf(client.getLastModifiedOn()));
            preStmt.setString(c++, client.getCreatedBy());
            preStmt.setDate(c++, Date.valueOf(client.getCreatedOn()));
            preStmt.setBoolean(c, client.isActive());
            preStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Query: " + insertAuthenticate);
    }

    public static void addNewRowToAuthenticateTable(Authenticate authenticate) {
        String insertAuthenticate = DbQueries.CREATE_TABLE_AUTHENTICATE;
        try {
            PreparedStatement preStmt = connection.prepareStatement(insertAuthenticate);
            int c = 1;
            preStmt.setString(c++, authenticate.getUserEmail());
            preStmt.setString(c++, authenticate.getPassword());

            preStmt.setString(c++, authenticate.getLastModifiedBy());
            preStmt.setDate(c++, Date.valueOf(authenticate.getLastModifiedOn()));
            preStmt.setString(c++, authenticate.getCreatedBy());
            preStmt.setDate(c++, Date.valueOf(authenticate.getCreatedOn()));
            preStmt.setBoolean(c, authenticate.isActive());
            preStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Query: " + insertAuthenticate);
    }

    public static void addNewRowToMilestoneTable(Milestone milestone) {
        String insertMileStone = DbQueries.INSERT_INTO_MILESTONE;
        try {
            PreparedStatement preStmt = connection.prepareStatement(insertMileStone);
            int c = 1;

            preStmt.setInt(c++, milestone.getMileNumber());
            preStmt.setInt(c++, milestone.getProjectId());
            preStmt.setString(c++, milestone.getTitle());
            preStmt.setString(c++, milestone.getDescription());
            preStmt.setInt(c++, milestone.getTimeInHours());
            preStmt.setInt(c++, milestone.getStatus());
            preStmt.setInt(c++, milestone.getAssignedToEmployeeId());
            preStmt.setInt(c++, milestone.getCompletedByEmployeeId());

            preStmt.setString(c++, milestone.getLastModifiedBy());
            preStmt.setDate(c++, Date.valueOf(milestone.getLastModifiedOn()));
            preStmt.setString(c++, milestone.getCreatedBy());
            preStmt.setDate(c++, Date.valueOf(milestone.getCreatedOn()));
            preStmt.setBoolean(c, milestone.isActive());
            preStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Query: " + insertMileStone);


    }

}
