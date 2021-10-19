import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ListeSQL {

    private final String url = "jdbc:mysql://localhost:3306/listedb";
    private final String user = "root";
    private final String password = "1234";
    private Connection myConn;
    private Statement myStatement;
    private List<Patient> patientList;


    public static ListeSQL sql;

    static {
        try {
            sql = new ListeSQL();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static ListeSQL getInstance() {
        return sql;
    }

    private ListeSQL() throws SQLException {

    }

    public List<Patient> getpatientList() throws SQLException {
        makeConnectionSQL();
        patientList = new ArrayList<>();
        String query = "SELECT * FROM patients";
        try {
            ResultSet rs = myStatement.executeQuery(query);

            while (rs.next()) {
                Patient p = new Patient();
                p.setCpr(String.valueOf(rs.getInt(1)));
                p.setName(rs.getString(2));

                patientList.add(p);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        removeConnectionSQL();
        return patientList;
    }

    public void insertPatientSQL(Patient p) throws SQLException {
        String cpr = p.getCpr();
        String navn = p.getName();
        String query = "INSERT INTO patients(cpr, navn) values (" + cpr + ", '" + navn + "')";
        makeConnectionSQL();
        myStatement.execute(query);
        removeConnectionSQL();
    }

    private void makeConnectionSQL() throws SQLException {
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

