package dbHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbQueries {

    private static DbQueries dbQueries;
    private static Connection connection;

    private DbQueries() {
    }

    public static DbQueries getInstance() {
        DatabaseHelper.getInstance();
        connection = DatabaseHelper.connection;
        if (dbQueries == null) dbQueries = new DbQueries();
        return dbQueries;
    }

    static final String DB_NAME = "PAS_DB";
    static final String DB_URL = "jdbc:mysql://localhost/";
    static final String DB_USER = "vijayjangid2000";
    static final String DB_PASSWORD = "vijay84529vijay";

    public final int EMP_ADMIN = 1, EMP_MANAGER = 2, EMP_DEVELOPER = 3;
    public final int EMP_IDLE = 1, EMP_HAVE_PROJECTS = 2, EMP_BUSY = 3, EMP_MAX_PROJECT = 5;
    public final int PRO_IDLE = 1, PRO_IN_PROGRESS = 2, PRO_COMPLETED = 3;
    public final int MILESTONE_IDLE = 1, MILESTONE_IN_PROGRESS = 2, MILESTONE_COMPLETED = 3;

    public final int EMPTY_INT_COLUMN = 0;

    public String[] roleOfEmployee = {"Admin", "Manager", "Developer"};
    public String[] domainExpertise = {"Banking", "Education", "Database", "Travel", "Finance"};

    static final String TABLE_NAME_MILESTONE = "Milestone";
    static final String TABLE_NAME_PROJECT = "Project";
    static final String TABLE_NAME_EMPLOYEE = "Employee";
    static final String TABLE_NAME_MEMBER = "Member";
    static final String TABLE_NAME_CLIENT = "Client";
    static final String TABLE_NAME_AUTHENTICATE = "Authenticate";

    static final String CREATE_DATABASE = "CREATE DATABASE " + DB_NAME + ";";

    static final String CREATE_TABLE_MILESTONE = """
            CREATE TABLE Milestone (
              uniqueId int primary key,\s
              mileNumber int ,\s
              projectId int ,\s
              title varchar(150) ,\s
              description varchar(1000) ,\s
              timeInHours int ,\s
              status int ,\s
              assignedToEmpId int ,\s
              completedByEmpId int ,\s
              lastModifiedBy varchar(255) ,\s
              lastModifiedOn DATETIME ,\s
              createdBy varchar(255) ,\s
              createdOn DATETIME ,\s
              isActive boolean\040
            );
            """;


    static final String CREATE_TABLE_MEMBER = """
            CREATE TABLE Member (
                    uniqueId int primary key,\s
                    projectId int ,\s
                    employeeId int ,
                     employeeRole int ,\s
                    isActive boolean\040
                  );
                  """;

    static final String CREATE_TABLE_PROJECT = """
            CREATE TABLE Project (
              uniqueId int primary key,\s
              title varchar(255) ,\s
              name varchar(255) ,\s
              description varchar(255) ,\s
              deadline DATETIME ,\s
              finishedOn DATETIME ,\s
              beforeDeadline DATETIME ,\s
              numOfEmpRequired int ,\s
              numOfEmpWorking int ,\s
              managerId int ,\s
              minimumExperience int ,\s
              numOfMinExp int ,
              totalMilestones int ,\s
              domainExpertId int ,\s
              clientId int ,\s
              lastModifiedBy varchar(255) ,\s
              lastModifiedOn DATETIME ,\s
              createdBy varchar(255) ,\s
              createdOn DATETIME ,\s
              isActive boolean\040
            );
            """;

    static final String CREATE_TABLE_EMPLOYEE = """
            CREATE TABLE Employee (
              uniqueId int primary key,\s
              name varchar(255) ,\s
              joiningDate DATETIME ,\s
              email varchar(100) ,\s
              mobile varchar(20) ,\s
              dob DATETIME ,\s
              managerId int ,\s
              assignedProject int ,\s
              roleInCompany int ,\s
              previousExperience int ,\s
              domainExpertise int ,\s
              lastModifiedBy varchar(255) ,\s
              lastModifiedOn DATETIME ,\s
              createdBy varchar(255) ,\s
              createdOn DATETIME ,\s
              isActive boolean\040
            );
            """;


    static final String CREATE_TABLE_CLIENT = """
                CREATE TABLE Client(
                uniqueId int primary key,
                firstName varchar(255) ,
                lastName varchar(255) ,
                companyName varchar(255) ,
                location varchar(255) ,
                companyEmail varchar(255) ,
                mobile varchar(255) ,
                email varchar(20) ,
                lastModifiedBy varchar(255) ,
                lastModifiedOn DATETIME ,
                createdBy varchar(255) ,
                createdOn DATETIME ,
                isActive boolean );\040
            """;

    static final String CREATE_TABLE_AUTHENTICATE = """
            CREATE TABLE Authenticate (
              uniqueId int primary key,\s
              userEmail varchar(255) ,\s
              userPassword varchar(255) ,\s
              lastModifiedBy varchar(255) ,\s
              lastModifiedOn DATETIME ,\s
              createdBy varchar(255) ,\s
              createdOn DATETIME ,\s
              isActive boolean
            );
            """;

    static final String INSERT_INTO_PROJECT = "INSERT INTO project (title, name, description, deadline , " +
            "finishedOn, beforeDeadline, numOfEmpRequired, numOfEmpWorking  , managerId , " +
            "minimumExperience , numOfMinExp , totalMilestones , domainExpertId , clientId , " +
            "lastModifiedBy , lastModifiedOn ,createdBy ,createdOn ,isActive) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

    static final String INSERT_INTO_AUTHENTICATE = "INSERT INTO authenticate  (userEmail , userPassword , " +
            "lastModifiedBy , lastModifiedOn , createdBy , createdOn , isActive) VALUES (?,?,?,?,?,?,?);";

    static final String INSERT_INTO_EMPLOYEE = "INSERT INTO employee  (name , joiningDate , email , " +
            "mobile , dob , managerId ,assignedProject ,roleInCompany ,previousExperience ,domainExpertise ," +
            "lastModifiedBy , lastModifiedOn , createdBy , createdOn , isActive)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

    static final String INSERT_INTO_CLIENT = "INSERT INTO client  (firstName , lastName , companyName , " +
            "location , companyEmail , mobile , email , lastModifiedBy , lastModifiedOn , createdBy , " +
            "createdOn , isActive) VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";

    static final String INSERT_INTO_MEMBER = " INSERT INTO member  (projectId ,employeeId ," +
            "employeeRole ,isActive) VALUES (?,?,?,?);";

    static final String INSERT_INTO_MILESTONE = "INSERT INTO milestone  (mileNumber ,projectId ,title , " +
            "description , timeInHours ,status ,assignedToEmpId ,completedByEmpId ,lastModifiedBy , " +
            "lastModifiedOn , createdBy , createdOn , isActive) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);";

    static final String OVERWRITE_PROJECT = "UPDATE project SET title= ?, name= ?, description= ?, deadline = ?, " +
            "finishedOn= ?, beforeDeadline= ?, numOfEmpRequired= ?, numOfEmpWorking  = ?, managerId = ?, " +
            "minimumExperience = ?, numOfMinExp = ?, totalMilestones = ?, domainExpertId = ?, clientId = ?, " +
            "lastModifiedBy = ?, lastModifiedOn = ?,createdBy = ?,createdOn = ?,isActive = ? where uniqueId = ?;";

    static final String OVERWRITE_AUTHENTICATE = "UPDATE authenticate SET userEmail = ?, userPassword = ?, " +
            "lastModifiedBy = ?, lastModifiedOn = ?, createdBy = ?, createdOn = ?, isActive=? where uniqueId = ?;";

    static final String OVERWRITE_EMPLOYEE = "UPDATE employee SET  name = ?, joiningDate = ?, email = ?, " +
            "mobile = ?, dob = ?, managerId = ?,assignedProject = ?,roleInCompany = ?,previousExperience = ?,domainExpertise = ?," +
            "lastModifiedBy = ?, lastModifiedOn = ?, createdBy = ?, createdOn = ?, isActive = ? where uniqueId = ?;";

    static final String OVERWRITE_CLIENT = "UPDATE client SET  firstName = ?, lastName = ?, companyName = ?, " +
            "location = ?, companyEmail = ?, mobile = ?, email = ?, lastModifiedBy = ?, lastModifiedOn = ?, createdBy = ?, " +
            "createdOn = ?, isActive=? where uniqueId = ?;";

    static final String OVERWRITE_MEMBER = " UPDATE member SET projectId = ?,employeeId = ?," +
            "employeeRole = ?,isActive =? where uniqueId = ?;";

    static final String OVERWRITE_MILESTONE = "UPDATE milestone SET  uniqueId= ?, mileNumber = ?,projectId = ?,title = ?, " +
            "description = ?, timeInHours = ?,status = ?,assignedToEmpId = ?,completedByEmpId = ?,lastModifiedBy = ?, " +
            "lastModifiedOn = ?, createdBy = ?, createdOn = ?, isActive = ? where uniqueId = ?;";

    static final String QUERY_AUTHENTICATE = "select * from authenticate;";
    static final String QUERY_CLIENT = "select * from client;";
    static final String QUERY_EMPLOYEE = "select * from employee;";
    static final String QUERY_MEMBER = "select * from member;";
    static final String QUERY_MILESTONE = "select * from milestone;";
    static final String QUERY_PROJECT = "select * from project;";

    static final String DELETE_ROW_AUTHENTICATE = "delete from authenticate where uniqueId = ?;";
    static final String DELETE_ROW_CLIENT = "delete from client where uniqueId = ?;";
    static final String DELETE_ROW_EMPLOYEE = "delete from employee where uniqueId = ?;";
    static final String DELETE_ROW_MEMBER = "delete from member where uniqueId = ?;";
    static final String DELETE_ROW_MILESTONE = "delete from milestone where uniqueId = ?;";
    static final String DELETE_ROW_PROJECT = "delete from project where uniqueId = ?;";

    public PreparedStatement psCheckAuthenticate(String email, String password) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement
                    ("SELECT * FROM authenticate where userEmail = ? AND userPassword = ?;");
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return preparedStatement;
    }

    public PreparedStatement psCheckEmployee(String email) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement
                    ("Select * from employee where email = ?;");
            preparedStatement.setString(1, email);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return preparedStatement;
    }

    public PreparedStatement psGetEmployees(String email) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement
                    ("Select * from employee where assignedProject < 5 ORDER BY assignedProject;");
            preparedStatement.setString(1, email);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return preparedStatement;
    }

    public PreparedStatement psGetProject(int STATUS) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement
                    ("Select * from project where status = ? AND isActive = ?;");
            preparedStatement.setInt(1, STATUS);
            preparedStatement.setBoolean(2, true);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return preparedStatement;
    }

    public PreparedStatement psGetEmployee(int experience, int domain) {

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement
                    ("Select * from employee where domainExpertise = ? AND previousExperience >= ? ORDER BY" +
                            " assignedProject ASEC;");
            int c = 1;
            preparedStatement.setInt(c, domain);
            preparedStatement.setInt(++c, experience);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return preparedStatement;
    }

}
