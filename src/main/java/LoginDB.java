import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDB {

    public static LoginDB Mysql;

    static {
        Mysql = new LoginDB();
    }


    public static LoginDB getInstance() {
        return Mysql;
    }

    public String hentBrugerListe(String s) throws SQLException {
        SQL.getSqlOBJ().makeConnectionSQL();
        String query1 = "SELECT * FROM listedb.LoginOplysninger WHERE USERNAME = '"+s+"';";
        String svar="";
        try {
            ResultSet rs = SQL.getSqlOBJ().myStatement.executeQuery(query1);
            while (rs.next()){
                svar =svar+rs.getString(1);
                svar = svar+"A"+rs.getString(2);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        SQL.getSqlOBJ().removeConnectionSQL();
       return svar;
    }

}
