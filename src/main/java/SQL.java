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

    private List<OGAftale> OGAftaleList;

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

    public List<OGAftale> getAftaleListeDateTime(String fra, String til) throws SQLException {
        SQL.getSqlOBJ().makeConnectionSQL();
        OGAftaleList = new ArrayList<>();
        try {
            PreparedStatement pp = myConn.prepareStatement("SELECT * FROM patients WHERE startTime BETWEEN ? and ?;");
            pp.setString(1,fra);
            pp.setString(2,til);

            ResultSet rs = pp.executeQuery();

            while (rs.next()) {
                OGAftale p = new OGAftale();
                p.setCpr(String.valueOf(rs.getInt(1)));
                p.setName(rs.getString(2));
                p.setTimestart(rs.getString(3));
                p.setTimeend(rs.getString(4));
                p.setNote(rs.getString(5));

                OGAftaleList.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        SQL.getSqlOBJ().removeConnectionSQL();

        return OGAftaleList;
    }

    public void insertAftaleSQL(OGAftale p) throws OurException {


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

    public List<OGAftale> getAftalerListe() throws SQLException {
        SQL.getSqlOBJ().makeConnectionSQL();
        OGAftaleList = new ArrayList<>();
        String query = "SELECT * FROM patients";
        try {
            ResultSet rs = SQL.getSqlOBJ().myStatement.executeQuery(query);

            while (rs.next()) {
                OGAftale p = new OGAftale();
                p.setCpr(String.valueOf(rs.getInt(1)));
                p.setName(rs.getString(2));
                p.setTimestart(rs.getString(3));
                p.setTimeend(rs.getString(4));
                p.setNote(rs.getString(5));

                OGAftaleList.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        SQL.getSqlOBJ().removeConnectionSQL();

        return OGAftaleList;
    }

    public String hentBrugerListe(String s) throws SQLException {
        SQL.getSqlOBJ().makeConnectionSQL();
        PreparedStatement pp = myConn.prepareStatement("SELECT * FROM listedb.LoginOplysninger WHERE USERNAME = ?;");
        pp.setString(1,s);
        String svar = "";
        try {
            ResultSet rs = pp.executeQuery();
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

