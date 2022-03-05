package dbHelper;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseHelper {

    private static DatabaseHelper databaseHelper;
    private static Connection connection;

    private DatabaseHelper() {
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

    public DatabaseHelper getInstance() {
        if (databaseHelper == null) databaseHelper = new DatabaseHelper();
        return databaseHelper;
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
        addNewRowToProjectTable(project, false);
    }

    /* Resetting application and Database */

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

    /* To add new row to tables, if enabled overwrite then unique id is also required in the objects. */

    public static void addNewRowToAuthenticateTable(Authenticate authenticate, boolean doOverwrite) {


        String insertAuthenticate;
        if (doOverwrite) insertAuthenticate = DbQueries.OVERWRITE_AUTHENTICATE;
        else insertAuthenticate = DbQueries.INSERT_INTO_AUTHENTICATE;

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

    public static void addNewRowToClientTable(Client client, boolean doOverwrite) {

        String insertClient;
        if (doOverwrite) insertClient = DbQueries.OVERWRITE_CLIENT;
        else insertClient = DbQueries.INSERT_INTO_CLIENT;

        try {
            PreparedStatement preStmt = connection.prepareStatement(insertClient);
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

        System.out.println("Query: " + insertClient);
    }

    public static void addNewRowToEmployeeTable(Employee employee, boolean doOverwrite) {
        String insertEmployee;
        if (doOverwrite) insertEmployee = DbQueries.OVERWRITE_EMPLOYEE;
        else insertEmployee = DbQueries.INSERT_INTO_EMPLOYEE;

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
            preStmt.setInt(c++, employee.getRoleInCompany());
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

    public static void addNewRowToMemberTable(Member member, boolean doOverwrite) {


        String insertMember;
        if (doOverwrite) insertMember = DbQueries.OVERWRITE_MEMBER;
        else insertMember = DbQueries.INSERT_INTO_MEMBER;
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

    public static void addNewRowToMilestoneTable(Milestone milestone, boolean doOverwrite) {

        String insertMileStone;
        if (doOverwrite) insertMileStone = DbQueries.OVERWRITE_MILESTONE;
        else insertMileStone = DbQueries.INSERT_INTO_MILESTONE;


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

    public static void addNewRowToProjectTable(Project project, boolean doOverwrite) {

        String insertProject;
        if (doOverwrite) insertProject = DbQueries.OVERWRITE_PROJECT;
        else insertProject = DbQueries.INSERT_INTO_PROJECT;

        try {
            PreparedStatement preStmt = connection.prepareStatement(insertProject);
            int c = 1;
            if (doOverwrite) preStmt.setInt(c++, project.getUniqueId());
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

    /* To convert the data returned from mysql query into Objects of class belonging to particular table */

    public static ArrayList<Authenticate> queryAuthenticate() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(DbQueries.QUERY_AUTHENTICATE);
            statement.close();
            return convertResultSetToAuthenticate(resultSet);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static ArrayList<Client> queryClient() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(DbQueries.QUERY_CLIENT);
            statement.close();
            return convertResultSetToClient(resultSet);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static ArrayList<Employee> queryEmployee() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(DbQueries.QUERY_EMPLOYEE);
            statement.close();
            return convertResultSetToEmployee(resultSet);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static ArrayList<Member> queryMember() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(DbQueries.QUERY_MEMBER);
            statement.close();
            return convertResultSetToMember(resultSet);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static ArrayList<Milestone> queryMilestone() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(DbQueries.QUERY_MILESTONE);
            statement.close();
            return convertResultSetToMilestone(resultSet);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static ArrayList<Project> queryProject() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(DbQueries.QUERY_PROJECT);
            statement.close();
            return convertResultSetToProject(resultSet);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /* Converts resultSet object to ArrayList of required Object */

    private static ArrayList<Authenticate> convertResultSetToAuthenticate(ResultSet resultSet) {
        ArrayList<Authenticate> list = new ArrayList<>();

        try (resultSet) {

            while (resultSet.next()) {
                Authenticate authenticate = new Authenticate();
                int c = 1;
                authenticate.setUniqueId(resultSet.getInt(c++));
                authenticate.setUserEmail(resultSet.getString(c++));
                authenticate.setPassword(resultSet.getString(c++));

                authenticate.setLastModifiedBy(resultSet.getString(c++));
                authenticate.setLastModifiedOn(resultSet.getDate(c++).toString());
                authenticate.setCreatedBy(resultSet.getString(c++));
                authenticate.setCreatedOn(resultSet.getDate(c++).toString());
                authenticate.setActive(resultSet.getBoolean(c));

                list.add(authenticate);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    private static ArrayList<Client> convertResultSetToClient(ResultSet resultSet) {
        ArrayList<Client> list = new ArrayList<>();

        try (resultSet) {

            while (resultSet.next()) {
                Client client = new Client();
                int c = 1;

                client.setUniqueId(resultSet.getInt(c++));
                client.setFirstName(resultSet.getString(c++));
                client.setLastName(resultSet.getString(c++));
                client.setCompanyName(resultSet.getString(c++));
                client.setLocation(resultSet.getString(c++));
                client.setCompanyEmail(resultSet.getString(c++));
                client.setMobile(resultSet.getString(c++));
                client.setEmail(resultSet.getString(c++));

                client.setLastModifiedBy(resultSet.getString(c++));
                client.setLastModifiedOn(resultSet.getDate(c++).toString());
                client.setCreatedBy(resultSet.getString(c++));
                client.setCreatedOn(resultSet.getDate(c++).toString());
                client.setActive(resultSet.getBoolean(c));

                list.add(client);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    private static ArrayList<Member> convertResultSetToMember(ResultSet resultSet) {
        ArrayList<Member> list = new ArrayList<>();

        try (resultSet) {
            while (resultSet.next()) {
                Member member = new Member();
                int c = 1;

                member.setUniqueId(resultSet.getInt(c++));
                member.setProjectId(resultSet.getInt(c++));
                member.setUniqueId(resultSet.getInt(c++));
                member.setEmployeeRole(resultSet.getInt(c++));

                member.setActive(resultSet.getBoolean(c));

                list.add(member);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    private static ArrayList<Employee> convertResultSetToEmployee(ResultSet resultSet) {
        ArrayList<Employee> list = new ArrayList<>();

        try (resultSet) {

            while (resultSet.next()) {
                Employee employee = new Employee();
                int c = 1;
                employee.setUniqueId(resultSet.getInt(c++));
                employee.setName(resultSet.getString(c++));
                employee.setJoiningDate(resultSet.getDate(c++).toString());
                employee.setEmail(resultSet.getString(c++));

                employee.setMobile(resultSet.getString(c++));
                employee.setDateOfBirth(resultSet.getDate(c++).toString());
                employee.setManagerId(resultSet.getInt(c++));

                employee.setNoOfAssignedProject(resultSet.getInt(c++));
                employee.setRoleInCompany(resultSet.getInt(c++));
                employee.setPreviousExperienceInYears(resultSet.getInt(c++));
                employee.setDomainExpertiseId(resultSet.getInt(c++));

                employee.setLastModifiedBy(resultSet.getString(c++));
                employee.setLastModifiedOn(resultSet.getDate(c++).toString());
                employee.setCreatedBy(resultSet.getString(c++));
                employee.setCreatedOn(resultSet.getDate(c++).toString());
                employee.setActive(resultSet.getBoolean(c));

                list.add(employee);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    private static ArrayList<Milestone> convertResultSetToMilestone(ResultSet resultSet) {
        ArrayList<Milestone> list = new ArrayList<>();

        try (resultSet) {

            while (resultSet.next()) {
                Milestone milestone = new Milestone();
                int c = 1;

                milestone.setUniqueId(resultSet.getInt(c++));
                milestone.setMileNumber(resultSet.getInt(c++));
                milestone.setProjectId(resultSet.getInt(c++));
                milestone.setTitle(resultSet.getString(c++));
                milestone.setDescription(resultSet.getString(c++));
                milestone.setStatus(resultSet.getInt(c++));
                milestone.setAssignedToEmployeeId(resultSet.getInt(c++));
                milestone.setCompletedByEmployeeId(resultSet.getInt(c++));

                milestone.setLastModifiedBy(resultSet.getString(c++));
                milestone.setLastModifiedOn(resultSet.getDate(c++).toString());
                milestone.setCreatedBy(resultSet.getString(c++));
                milestone.setCreatedOn(resultSet.getDate(c++).toString());
                milestone.setActive(resultSet.getBoolean(c));

                list.add(milestone);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    private static ArrayList<Project> convertResultSetToProject(ResultSet resultSet) {

        ArrayList<Project> list = new ArrayList<>();

        try (resultSet) {

            while (resultSet.next()) {
                Project project = new Project();
                int c = 1;
                project.setUniqueId(resultSet.getInt(c++));
                project.setTitle(resultSet.getString(c++));
                project.setName(resultSet.getString(c++));
                project.setDescription(resultSet.getString(c++));

                project.setDeadLine(resultSet.getDate(c++).toString());
                project.setFinishedOn(resultSet.getDate(c++).toString());
                project.setBeforeDeadline(resultSet.getBoolean(c++));

                project.setNumberOfEmployeeRequired(resultSet.getInt(c++));
                project.setNumberOfEmployeeWorking(resultSet.getInt(c++));
                project.setManagerId(resultSet.getInt(c++));
                project.setMinimumExperience(resultSet.getInt(c++));
                project.setNumberOfExperienced(resultSet.getInt(c++));
                project.setTotalMilestones(resultSet.getInt(c++));
                project.setDomainExpert(resultSet.getInt(c++));
                project.setClientId(resultSet.getInt(c++));

                project.setLastModifiedBy(resultSet.getString(c++));
                project.setLastModifiedOn(resultSet.getDate(c++).toString());
                project.setCreatedBy(resultSet.getString(c++));
                project.setCreatedOn(resultSet.getDate(c++).toString());
                project.setActive(resultSet.getBoolean(c));

                list.add(project);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }


}
