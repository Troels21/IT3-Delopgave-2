import java.sql.*;

public class SQL {
    /*
    SQL SCRIPT
    #CREATE DATABASE listedb;
    USE listedb;

    CREATE TABLE patients (
            cpr INT,
            navn VARCHAR(60),
    startTime datetime unique,
    endTime datetime unique,
    note VARCHAR(255));*/

    private SQL() {}
    static private final SQL sqlOBJ = new SQL();
    static public SQL getSqlOBJ() {
        return sqlOBJ;
    }

    private final String url = "jdbc:mysql://localhost:3306/listedb";
    private final String user = "root";
    private final String password = "1234";
    private Connection myConn;
    public Statement myStatement;


    public void makeConnectionSQL() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        myConn = DriverManager.getConnection(url, user, password);
        myStatement = myConn.createStatement();
    }

    public void removeConnectionSQL() {
        try {
            if (!myConn.isClosed()) {
                myConn.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
