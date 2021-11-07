import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQL {

    private SQL() {
    }

    static private final SQL sqlOBJ = new SQL();

    static public SQL getSqlOBJ() {
        return sqlOBJ;
    }

    private final String url = "jdbc:mysql://130.225.170.176:3306/listedb";
    private final String DatabaseUser = "test2";
    private final String DatabasePassword = "faxe2021";

    private Connection myConn;
    public Statement myStatement;

    private List<Aftale> AftaleList;

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

    public List<Aftale> getAftaleListeDateTime(String fra, String til) throws SQLException {
        SQL.getSqlOBJ().makeConnectionSQL();
        AftaleList = new ArrayList<>();
        String query = "SELECT * FROM patients WHERE startTime BETWEEN '" + fra + "' and '" + til + "';";
        try {
            ResultSet rs = SQL.getSqlOBJ().myStatement.executeQuery(query);

            while (rs.next()) {
                Aftale p = new Aftale();
                p.setCpr(String.valueOf(rs.getInt(1)));
                p.setName(rs.getString(2));
                p.setTimestart(rs.getString(3));
                p.setTimeend(rs.getString(4));
                p.setNote(rs.getString(5));

                AftaleList.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        SQL.getSqlOBJ().removeConnectionSQL();

        return AftaleList;
    }

    public void insertAftaleSQL(Aftale p) throws OurException {


        try {
            makeConnectionSQL();
            PreparedStatement pp = myConn.prepareStatement("INSERT INTO patients(cpr, navn, startTime, endTime, note) values(?,?,?,?,?);");

            pp.setString(1, p.getCpr());//CPR
            pp.setString(2, p.getName());//navn
            pp.setString(3, p.getTimestart());   //starttime
            pp.setString(4, p.getTimeend());   //endtime
            pp.setString(5, p.getNote());  //not

            pp.execute();

            removeConnectionSQL();
        } catch (SQLException e) {
            OurException ex = new OurException();
            ex.setMessage("Den tid er allerede optaget");
            throw ex;
        }
    }

    public List<Aftale> getAftalerListe() throws SQLException {
        SQL.getSqlOBJ().makeConnectionSQL();
        AftaleList = new ArrayList<>();
        String query = "SELECT * FROM patients";
        try {
            ResultSet rs = SQL.getSqlOBJ().myStatement.executeQuery(query);

            while (rs.next()) {
                Aftale p = new Aftale();
                p.setCpr(String.valueOf(rs.getInt(1)));
                p.setName(rs.getString(2));
                p.setTimestart(rs.getString(3));
                p.setTimeend(rs.getString(4));
                p.setNote(rs.getString(5));

                AftaleList.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        SQL.getSqlOBJ().removeConnectionSQL();

        return AftaleList;
    }

    public String hentBrugerListe(String s) throws SQLException {
        SQL.getSqlOBJ().makeConnectionSQL();
        String query1 = "SELECT * FROM listedb.LoginOplysninger WHERE USERNAME = '" + s + "';";
        String svar = "";
        try {
            ResultSet rs = SQL.getSqlOBJ().myStatement.executeQuery(query1);
            while (rs.next()) {
                svar = svar + rs.getString(1);
                svar = svar + "A" + rs.getString(2);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        SQL.getSqlOBJ().removeConnectionSQL();
        return svar;
    }
}

