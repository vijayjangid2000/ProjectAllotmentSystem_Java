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

    static final String CREATE_DATABASE = "CREATE DATABASE " + DB_NAME  + ";";

    static final String CREATE_TABLE_MILESTONE = """
            CREATE TABLE Milestone (
              uniqueId int primary key,\s
              mileNumber int not null,\s
              projectId int NOT NULL,\s
              title varchar(150) NOT NULL,\s
              description varchar(1000) NOT NULL,\s
              timeInHours int NOT NULL,\s
              status int NOT NULL,\s
              assignedToEmpId int NOT NULL,\s
              completedByEmpId int NOT NULL,\s
              lastModifiedBy varchar(255) NOT NULL,\s
              lastModifiedOn DATETIME NOT NULL,\s
              createdBy varchar(255) NOT NULL,\s
              createdOn DATETIME NOT NULL,\s
              isActive boolean NOT NULL
            );
            """;


    static final String CREATE_TABLE_MEMBER = """
            CREATE TABLE Member (
                    uniqueId int primary key,\s
                    projectId int NOT NULL,\s
                    employeeId int NOT NULL,
                     employeeRole int NOT NULL,\s
                    isActive boolean NOT NULL
                  );
                  """;

    static final String CREATE_TABLE_PROJECT = """
            CREATE TABLE Project (
              uniqueId int primary key,\s
              title varchar(255) NOT NULL,\s
              name varchar(255) NOT NULL,\s
              description varchar(255) NOT NULL,\s
              deadline DATETIME NOT NULL,\s
              finishedOn DATETIME NOT NULL,\s
              beforeDeadline DATETIME NOT NULL,\s
              numOfEmpRequired int NOT null,\s
              numOfEmpWorking int not null,\s
              managerId int not null,\s
              minimumExperience int not null,\s
              numOfMinExp int not null,
              totalMilestones int not null,\s
              domainExpertId int not null,\s
              clientId int not null,\s
              lastModifiedBy varchar(255) NOT NULL,\s
              lastModifiedOn DATETIME NOT NULL,\s
              createdBy varchar(255) NOT NULL,\s
              createdOn DATETIME NOT NULL,\s
              isActive boolean NOT NULL
            );
            """;

    static final String CREATE_TABLE_EMPLOYEE = """
            CREATE TABLE Employee (
              uniqueId int primary key,\s
              name varchar(255) not null,\s
              joiningDate DATETIME not null,\s
              email varchar(100) not null,\s
              mobile varchar(20) not null,\s
              dob DATETIME not null,\s
              managerId int not null,\s
              assignedProject int not null,\s
              rankInCompany int not null,\s
              previousExperience int not null,\s
              domainExpertise int not null,\s
              lastModifiedBy varchar(255) NOT NULL,\s
              lastModifiedOn DATETIME NOT NULL,\s
              createdBy varchar(255) NOT NULL,\s
              createdOn DATETIME NOT NULL,\s
              isActive boolean NOT NULL
            );
            """;


    static final String CREATE_TABLE_CLIENT = """
                CREATE TABLE Client(
                uniqueId int primary key,
                firstName varchar(255) not null,
                lastName varchar(255) not null,
                companyName varchar(255) not null,
                location varchar(255) not null,
                companyEmail varchar(255) not null,
                mobile varchar(255) not null,
                email varchar(20) not null,
                lastModifiedBy varchar(255) NOT NULL,
                lastModifiedOn DATETIME NOT NULL,
                createdBy varchar(255) NOT NULL,
                createdOn DATETIME NOT NULL,
                isActive boolean NOT NULL);\040
            """;

    static final String CREATE_TABLE_AUTHENTICATE = """
            CREATE TABLE Authenticate (
              uniqueId int primary key,\s
              userEmail varchar(255) not null,\s
              userPassword varchar(255) not null,\s
              lastModifiedBy varchar(255) NOT NULL,\s
              lastModifiedOn DATETIME NOT NULL,\s
              createdBy varchar(255) NOT NULL,\s
              createdOn DATETIME NOT NULL,\s
              isActive boolean NOT NULL
            );
            """;

    static final String INSERT_INTO_PROJECT = "";
    static final String INSERT_INTO_AUTHENTICATE = "";
    static final String INSERT_INTO_EMPLOYEE = "";
    static final String INSERT_INTO_CLIENT = "";
    static final String INSERT_INTO_MEMBER  = " ";
    static final String INSERT_INTO_MILESTONE = "";
}
