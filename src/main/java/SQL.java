import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

    private SQL() {
    }

    static private final SQL sqlOBJ = new SQL();

    static public SQL getSqlOBJ() {
        return sqlOBJ;
    }

    private final String SSHhost = "130.225.170.176:22022";
    private final String SSHUser = "s205869";

    private final String url = "jdbc:mysql://localhost:3306/listedb";
    private final String DatabaseHost="127.0.0.1";
    private final String DatabaseUser = "root";
    private final String DatabasePassword = "faxe2021";
    private final int DatabasePort = 3306;
    private int forwardport;

    private Connection myConn;
    public Statement myStatement;
    private Session session;


    public void makeConnectionSQL() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        myConn = DriverManager.getConnection(url, DatabaseUser, DatabasePassword);
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

    public void tunnelSSH() {
        JSch jSch = new JSch();

        try {
            FileInputStream fis = new FileInputStream("/src/main/resources/Key_openSSH");
            jSch.addIdentity(fis.toString());
            session = jSch.getSession(SSHUser,SSHhost);

            int forwardport = session.setPortForwardingL(0,DatabaseHost,DatabasePort);

        } catch (FileNotFoundException | JSchException e) {
            e.printStackTrace();
        }



    }

}
