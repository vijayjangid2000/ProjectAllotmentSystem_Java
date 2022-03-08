package dbHelper;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseHelper {

    boolean printStackTrace = true, printMessage = true;

    private static DatabaseHelper databaseHelper;
    public static Connection connection;

    private DatabaseHelper() {
        try {
            connection = DriverManager.getConnection(DbQueries.DB_URL,
                    DbQueries.DB_USER, DbQueries.DB_PASSWORD);
            Statement statement = connection.createStatement();
            statement.executeUpdate("USE " + DbQueries.DB_NAME);
            statement.close();
            System.out.println("DB Connected.");

        } catch (SQLException e) {
            if (printStackTrace) e.printStackTrace();
            if (printMessage) System.out.println(e.getMessage());
        }
    }

    public static DatabaseHelper getInstance() {
        if (databaseHelper == null) databaseHelper = new DatabaseHelper();
        return databaseHelper;
    }

    /* Resetting application and Database */

    public void createAllTablesAndDb() {

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
            if (printStackTrace) e.printStackTrace();
            if (printMessage) System.out.println(e.getMessage());
        }

    }

    /* To add new row to tables, if enabled overwrite then unique id is also required in the objects. */

    public void addNewRowToAuthenticateTable(Authenticate authenticate, boolean doOverwrite) {

        String insertAuthenticate;
        if (doOverwrite) insertAuthenticate = DbQueries.OVERWRITE_AUTHENTICATE;
        else insertAuthenticate = DbQueries.INSERT_INTO_AUTHENTICATE;

        try {
            PreparedStatement preStmt = connection.prepareStatement(insertAuthenticate);
            int c = 1;
            preStmt.setString(c++, authenticate.getUserEmail());
            preStmt.setString(c++, authenticate.getPassword());

            preStmt.setString(c++, authenticate.getLastModifiedBy());
            preStmt.setString(c++, authenticate.getLastModifiedOn());
            preStmt.setString(c++, authenticate.getCreatedBy());
            preStmt.setString(c++, authenticate.getCreatedOn());
            preStmt.setBoolean(c++, authenticate.isActive());
            preStmt.setInt(c, authenticate.getUniqueId());
            preStmt.execute();

        } catch (SQLException e) {
            if (printStackTrace) e.printStackTrace();
            if (printMessage) System.out.println(e.getMessage());
        }

        System.out.println("Query: " + insertAuthenticate);
    }

    public void addNewRowToClientTable(Client client, boolean doOverwrite) {

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
            preStmt.setString(c++, client.getLastModifiedOn());
            preStmt.setString(c++, client.getCreatedBy());
            preStmt.setString(c++, client.getCreatedOn());
            preStmt.setBoolean(c++, client.isActive());
            preStmt.setInt(c, client.getUniqueId());
            preStmt.execute();
        } catch (SQLException e) {
            if (printStackTrace) e.printStackTrace();
            if (printMessage) System.out.println(e.getMessage());
        }

        System.out.println("Query: " + insertClient);
    }

    public void addNewRowToEmployeeTable(Employee employee, boolean doOverwrite) {
        String insertEmployee;
        if (doOverwrite) insertEmployee = DbQueries.OVERWRITE_EMPLOYEE;
        else insertEmployee = DbQueries.INSERT_INTO_EMPLOYEE;

        try {
            PreparedStatement preStmt = connection.prepareStatement(insertEmployee);
            int c = 1;

            preStmt.setString(c++, employee.getName());

            preStmt.setString(c++, employee.getJoiningDate());
            preStmt.setString(c++, employee.getEmail());
            preStmt.setString(c++, employee.getMobile());

            preStmt.setString(c++, employee.getDateOfBirth());

            preStmt.setInt(c++, employee.getManagerId());
            preStmt.setInt(c++, employee.getNoOfAssignedProject());
            preStmt.setInt(c++, employee.getRoleInCompany());
            preStmt.setInt(c++, employee.getPreviousExperienceInYears());
            preStmt.setInt(c++, employee.getDomainExpertiseId());

            preStmt.setString(c++, employee.getLastModifiedBy());
            preStmt.setString(c++, employee.getLastModifiedOn());
            preStmt.setString(c++, employee.getCreatedBy());
            preStmt.setString(c++, employee.getCreatedOn());
            preStmt.setBoolean(c++, employee.isActive());
            preStmt.setInt(c, employee.getUniqueId());

            preStmt.execute();
        } catch (SQLException e) {
            if (printStackTrace) e.printStackTrace();
            if (printMessage) System.out.println(e.getMessage());
        }

        System.out.println("Query: " + insertEmployee);
    }

    public void addNewRowToMemberTable(Member member, boolean doOverwrite) {


        String insertMember;
        if (doOverwrite) insertMember = DbQueries.OVERWRITE_MEMBER;
        else insertMember = DbQueries.INSERT_INTO_MEMBER;
        try {
            PreparedStatement preStmt = connection.prepareStatement(insertMember);
            int c = 1;
            preStmt.setInt(c++, member.getProjectId());
            preStmt.setInt(c++, member.getEmployeeId());
            preStmt.setInt(c++, member.getEmployeeRole());

            preStmt.setBoolean(c++, member.isActive());
            preStmt.setInt(c, member.getUniqueId());
            preStmt.execute();
        } catch (SQLException e) {
            if (printStackTrace) e.printStackTrace();
            if (printMessage) System.out.println(e.getMessage());
        }

        System.out.println("Query: " + insertMember);

    }

    public void addNewRowToMilestoneTable(Milestone milestone, boolean doOverwrite) {

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
            preStmt.setString(c++, milestone.getLastModifiedOn());
            preStmt.setString(c++, milestone.getCreatedBy());
            preStmt.setString(c++, milestone.getCreatedOn());
            preStmt.setBoolean(c++, milestone.isActive());
            preStmt.setInt(c, milestone.getUniqueId());
            preStmt.execute();
        } catch (SQLException e) {
            if (printStackTrace) e.printStackTrace();
            if (printMessage) System.out.println(e.getMessage());
        }

        System.out.println("Query: " + insertMileStone);


    }

    public void addNewRowToProjectTable(Project project, boolean doOverwrite) {

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

            preStmt.setString(c++, project.getDeadLine());
            preStmt.setString(c++, project.getFinishedOn());
            preStmt.setBoolean(c++, project.isBeforeDeadline());

            preStmt.setInt(c++, project.getNumberOfEmployeeRequired());
            preStmt.setInt(c++, project.getNumberOfEmployeeWorking());
            preStmt.setInt(c++, project.getManagerId());
            preStmt.setInt(c++, project.getMinimumExperience());
            preStmt.setInt(c++, project.getNumberOfExperienced());
            preStmt.setInt(c++, project.getStatus());
            preStmt.setInt(c++, project.getDomainExpert());
            preStmt.setInt(c++, project.getClientId());

            preStmt.setString(c++, project.getLastModifiedBy());
            preStmt.setString(c++, project.getLastModifiedOn());
            preStmt.setString(c++, project.getCreatedBy());
            preStmt.setString(c++, project.getCreatedOn());
            preStmt.setBoolean(c++, project.isActive());
            preStmt.setInt(c, project.getUniqueId());

            preStmt.execute();
        } catch (SQLException e) {
            if (printStackTrace) e.printStackTrace();
            if (printMessage) System.out.println(e.getMessage());
        }

        System.out.println("Query: " + insertProject);
    }

    /* Deleting queries for tables */

    public boolean deleteFromAuthenticate(int uniqueId) {

        String delete = DbQueries.DELETE_ROW_AUTHENTICATE;

        try {
            PreparedStatement preStmt = connection.prepareStatement(delete);
            int c = 1;
            preStmt.setInt(c, uniqueId);
            preStmt.execute();
            return true;
        } catch (SQLException e) {
            if (printStackTrace) e.printStackTrace();
            if (printMessage) System.out.println(e.getMessage());
        }

        System.out.println("Query: " + delete);
        return false;
    }

    public boolean deleteFromClient(int uniqueId) {

        String delete = DbQueries.DELETE_ROW_CLIENT;

        try {
            PreparedStatement preStmt = connection.prepareStatement(delete);
            int c = 1;
            preStmt.setInt(c, uniqueId);
            preStmt.execute();
            return true;
        } catch (SQLException e) {
            if (printStackTrace) e.printStackTrace();
            if (printMessage) System.out.println(e.getMessage());
        }

        System.out.println("Query: " + delete);
        return false;
    }

    public boolean deleteFromEmployee(int uniqueId) {

        String delete = DbQueries.DELETE_ROW_EMPLOYEE;

        try {
            PreparedStatement preStmt = connection.prepareStatement(delete);
            int c = 1;
            preStmt.setInt(c, uniqueId);
            preStmt.execute();
            return true;
        } catch (SQLException e) {
            if (printStackTrace) e.printStackTrace();
            if (printMessage) System.out.println(e.getMessage());
        }

        System.out.println("Query: " + delete);
        return false;
    }

    public boolean deleteFromMember(int uniqueId) {

        String delete = DbQueries.DELETE_ROW_MEMBER;

        try {
            PreparedStatement preStmt = connection.prepareStatement(delete);
            int c = 1;
            preStmt.setInt(c, uniqueId);
            preStmt.execute();
            return true;
        } catch (SQLException e) {
            if (printStackTrace) e.printStackTrace();
            if (printMessage) System.out.println(e.getMessage());
        }

        System.out.println("Query: " + delete);
        return false;
    }

    public boolean deleteFromMilestone(int uniqueId) {

        String delete = DbQueries.DELETE_ROW_MILESTONE;

        try {
            PreparedStatement preStmt = connection.prepareStatement(delete);
            int c = 1;
            preStmt.setInt(c, uniqueId);
            preStmt.execute();
            return true;
        } catch (SQLException e) {
            if (printStackTrace) e.printStackTrace();
            if (printMessage) System.out.println(e.getMessage());
        }

        System.out.println("Query: " + delete);
        return false;
    }

    public boolean deleteFromProject(int uniqueId) {

        String delete = DbQueries.DELETE_ROW_PROJECT;

        try {
            PreparedStatement preStmt = connection.prepareStatement(delete);
            int c = 1;
            preStmt.setInt(c, uniqueId);
            preStmt.execute();
            return true;
        } catch (SQLException e) {
            if (printStackTrace) e.printStackTrace();
            if (printMessage) System.out.println(e.getMessage());
        }

        System.out.println("Query: " + delete);
        return false;
    }

    /* To convert the data returned from mysql query into Objects of class belonging to particular table */

    public ArrayList<Authenticate> queryAuthenticate(String customQuery) {
        try {
            if (customQuery == null) customQuery = DbQueries.QUERY_AUTHENTICATE;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(customQuery);
            //statement.close();
            return convertResultSetToAuthenticate(resultSet);

        } catch (Exception e) {
            if (printStackTrace) e.printStackTrace();
            if (printMessage) System.out.println(e.getMessage());
        }

        return null;
    }

    public ArrayList<Client> queryClient(String customQuery) {
        try {
            if (customQuery == null) customQuery = DbQueries.QUERY_CLIENT;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(customQuery);
            //statement.close();
            return convertResultSetToClient(resultSet);

        } catch (Exception e) {
            if (printStackTrace) e.printStackTrace();
            if (printMessage) System.out.println(e.getMessage());
        }

        return null;
    }

    public ArrayList<Employee> queryEmployee(String customQuery) {
        try {
            if (customQuery == null) customQuery = DbQueries.QUERY_EMPLOYEE;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(customQuery);
            //statement.close();
            return convertResultSetToEmployee(resultSet);

        } catch (Exception e) {
            if (printStackTrace) e.printStackTrace();
            if (printMessage) System.out.println(e.getMessage());
        }

        return null;
    }

    public ArrayList<Member> queryMember(String customQuery) {
        try {
            if (customQuery == null) customQuery = DbQueries.QUERY_MEMBER;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(customQuery);
            //statement.close();
            return convertResultSetToMember(resultSet);

        } catch (Exception e) {
            if (printStackTrace) e.printStackTrace();
            if (printMessage) System.out.println(e.getMessage());
        }

        return null;
    }

    public ArrayList<Milestone> queryMilestone(String customQuery) {
        try {
            if (customQuery == null) customQuery = DbQueries.QUERY_MILESTONE;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(customQuery);
            //statement.close();
            return convertResultSetToMilestone(resultSet);

        } catch (Exception e) {
            if (printStackTrace) e.printStackTrace();
            if (printMessage) System.out.println(e.getMessage());
        }

        return null;
    }

    public ArrayList<Project> queryProject(String customQuery) {
        try {
            if (customQuery == null) customQuery = DbQueries.QUERY_PROJECT;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(customQuery);
            //statement.close();
            return convertResultSetToProject(resultSet);

        } catch (Exception e) {
            if (printStackTrace) e.printStackTrace();
            if (printMessage) System.out.println(e.getMessage());
        }

        return null;
    }

    /* Converts resultSet object to ArrayList of required Object */

    private ArrayList<Authenticate> convertResultSetToAuthenticate(ResultSet resultSet) {

        ArrayList<Authenticate> list = new ArrayList<>();

        try (resultSet) {

            while (resultSet.next()) {
                Authenticate authenticate = new Authenticate();
                int c = 1;
                authenticate.setUniqueId(resultSet.getInt(c++));
                authenticate.setUserEmail(resultSet.getString(c++));
                authenticate.setPassword(resultSet.getString(c++));

                authenticate.setLastModifiedBy(resultSet.getString(c++));
                authenticate.setLastModifiedOn(resultSet.getString(c++).toString());
                authenticate.setCreatedBy(resultSet.getString(c++));
                authenticate.setCreatedOn(resultSet.getString(c++).toString());
                authenticate.setActive(resultSet.getBoolean(c));

                list.add(authenticate);
            }


            resultSet.close();
        } catch (Exception e) {
            if (printStackTrace) e.printStackTrace();
            if (printMessage) System.out.println(e.getMessage());
        }

        return list;
    }

    private ArrayList<Client> convertResultSetToClient(ResultSet resultSet) {
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
                client.setLastModifiedOn(resultSet.getString(c++).toString());
                client.setCreatedBy(resultSet.getString(c++));
                client.setCreatedOn(resultSet.getString(c++).toString());
                client.setActive(resultSet.getBoolean(c));

                list.add(client);
            }
            resultSet.close();
        } catch (Exception e) {
            if (printStackTrace) e.printStackTrace();
            if (printMessage) System.out.println(e.getMessage());
        }

        return list;
    }

    private ArrayList<Member> convertResultSetToMember(ResultSet resultSet) {
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
            resultSet.close();
        } catch (Exception e) {
            if (printStackTrace) e.printStackTrace();
            if (printMessage) System.out.println(e.getMessage());
        }

        return list;
    }

    private ArrayList<Employee> convertResultSetToEmployee(ResultSet resultSet) {
        ArrayList<Employee> list = new ArrayList<>();

        try (resultSet) {

            while (resultSet.next()) {
                Employee employee = new Employee();
                int c = 1;
                employee.setUniqueId(resultSet.getInt(c++));
                employee.setName(resultSet.getString(c++));
                employee.setJoiningDate(resultSet.getString(c++).toString());
                employee.setEmail(resultSet.getString(c++));

                employee.setMobile(resultSet.getString(c++));
                employee.setDateOfBirth(resultSet.getString(c++).toString());
                employee.setManagerId(resultSet.getInt(c++));

                employee.setNoOfAssignedProject(resultSet.getInt(c++));
                employee.setRoleInCompany(resultSet.getInt(c++));
                employee.setPreviousExperienceInYears(resultSet.getInt(c++));
                employee.setDomainExpertiseId(resultSet.getInt(c++));

                employee.setLastModifiedBy(resultSet.getString(c++));
                employee.setLastModifiedOn(resultSet.getString(c++).toString());
                employee.setCreatedBy(resultSet.getString(c++));
                employee.setCreatedOn(resultSet.getString(c++).toString());
                employee.setActive(resultSet.getBoolean(c));

                list.add(employee);
            }
            resultSet.close();
        } catch (Exception e) {
            if (printStackTrace) e.printStackTrace();
            if (printMessage) System.out.println(e.getMessage());
        }

        return list;
    }

    private ArrayList<Milestone> convertResultSetToMilestone(ResultSet resultSet) {
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
                milestone.setLastModifiedOn(resultSet.getString(c++).toString());
                milestone.setCreatedBy(resultSet.getString(c++));
                milestone.setCreatedOn(resultSet.getString(c++).toString());
                milestone.setActive(resultSet.getBoolean(c));

                list.add(milestone);
            }
            resultSet.close();
        } catch (Exception e) {
            if (printStackTrace) e.printStackTrace();
            if (printMessage) System.out.println(e.getMessage());
        }

        return list;
    }

    private ArrayList<Project> convertResultSetToProject(ResultSet resultSet) {

        ArrayList<Project> list = new ArrayList<>();

        try (resultSet) {

            while (resultSet.next()) {
                Project project = new Project();
                int c = 1;
                project.setUniqueId(resultSet.getInt(c++));
                project.setTitle(resultSet.getString(c++));
                project.setName(resultSet.getString(c++));
                project.setDescription(resultSet.getString(c++));

                project.setDeadLine(resultSet.getString(c++).toString());
                project.setFinishedOn(resultSet.getString(c++).toString());
                project.setBeforeDeadline(resultSet.getBoolean(c++));

                project.setNumberOfEmployeeRequired(resultSet.getInt(c++));
                project.setNumberOfEmployeeWorking(resultSet.getInt(c++));
                project.setManagerId(resultSet.getInt(c++));
                project.setMinimumExperience(resultSet.getInt(c++));
                project.setNumberOfExperienced(resultSet.getInt(c++));
                project.setStatus(resultSet.getInt(c++));
                project.setDomainExpert(resultSet.getInt(c++));
                project.setClientId(resultSet.getInt(c++));

                project.setLastModifiedBy(resultSet.getString(c++));
                project.setLastModifiedOn(resultSet.getString(c++).toString());
                project.setCreatedBy(resultSet.getString(c++));
                project.setCreatedOn(resultSet.getString(c++).toString());
                project.setActive(resultSet.getBoolean(c));

                list.add(project);
            }
            resultSet.close();
        } catch (Exception e) {
            if (printStackTrace) e.printStackTrace();
            if (printMessage) System.out.println(e.getMessage());
        }

        return list;
    }

    /* Specific queries that needs parameters */

    public ArrayList<Authenticate> queryAuthenticate(PreparedStatement statement) {
        try {
            ResultSet resultSet = statement.executeQuery();
            ////statement.close();
            return convertResultSetToAuthenticate(resultSet);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public ArrayList<Client> queryClient(PreparedStatement statement) {
        try {

            ResultSet resultSet = statement.executeQuery();
            ////statement.close();
            return convertResultSetToClient(resultSet);

        } catch (Exception e) {
            if (printStackTrace) e.printStackTrace();
            if (printMessage) System.out.println(e.getMessage());
        }

        return null;
    }

    public ArrayList<Employee> queryEmployee(PreparedStatement statement) {
        try {

            ResultSet resultSet = statement.executeQuery();
            ////statement.close();
            return convertResultSetToEmployee(resultSet);

        } catch (Exception e) {
            if (printStackTrace) e.printStackTrace();
            if (printMessage) System.out.println(e.getMessage());
        }

        return null;
    }

    public ArrayList<Member> queryMember(PreparedStatement statement) {
        try {

            ResultSet resultSet = statement.executeQuery();
            ////statement.close();
            return convertResultSetToMember(resultSet);

        } catch (Exception e) {
            if (printStackTrace) e.printStackTrace();
            if (printMessage) System.out.println(e.getMessage());
        }

        return null;
    }

    public ArrayList<Milestone> queryMilestone(PreparedStatement statement) {
        try {

            ResultSet resultSet = statement.executeQuery();
            ////statement.close();
            return convertResultSetToMilestone(resultSet);

        } catch (Exception e) {
            if (printStackTrace) e.printStackTrace();
            if (printMessage) System.out.println(e.getMessage());
        }

        return null;
    }

    public ArrayList<Project> queryProject(PreparedStatement statement) {
        try {

            ResultSet resultSet = statement.executeQuery();
            //statement.close();
            return convertResultSetToProject(resultSet);

        } catch (Exception e) {
            if (printStackTrace) e.printStackTrace();
            if (printMessage) System.out.println(e.getMessage());
        }

        return null;
    }
}
