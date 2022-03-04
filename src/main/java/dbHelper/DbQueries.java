package dbHelper;

public class DbQueries {

    static final String DB_NAME = "PAS_DB";
    static final String DB_URL = "jdbc:mysql://localhost/";
    static final String DB_USER = "vijayjangid2000";
    static final String DB_PASSWORD = "vijay84529vijay";

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
              isActive boolean 
            );
            """;


    static final String CREATE_TABLE_MEMBER = """
            CREATE TABLE Member (
                    uniqueId int primary key,\s
                    projectId int ,\s
                    employeeId int ,
                     employeeRole int ,\s
                    isActive boolean 
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
              isActive boolean 
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
              rankInCompany int ,\s
              previousExperience int ,\s
              domainExpertise int ,\s
              lastModifiedBy varchar(255) ,\s
              lastModifiedOn DATETIME ,\s
              createdBy varchar(255) ,\s
              createdOn DATETIME ,\s
              isActive boolean 
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
            "mobile , dob , managerId ,assignedProject ,rankInCompany ,previousExperience ,domainExpertise ," +
            "lastModifiedBy , lastModifiedOn , createdBy , createdOn , isActive)  VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

    static final String INSERT_INTO_CLIENT = "INSERT INTO client  (firstName , lastName , companyName , " +
            "location , companyEmail , mobile , email , lastModifiedBy , lastModifiedOn , createdBy , " +
            "createdOn , isActive) VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";

    static final String INSERT_INTO_MEMBER = " INSERT INTO member  (uniqueId ,PK projectId ,employeeId ," +
            "employeeRole ,isActive) VALUES (?,?,?,?,?);";

    static final String INSERT_INTO_MILESTONE = "INSERT INTO milestone  (mileNumber ,projectId ,title , " +
            "description , timeInHours ,status ,assignedToEmpId ,completedByEmpId ,lastModifiedBy , " +
            "lastModifiedOn , createdBy , createdOn , isActive) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);";

}
