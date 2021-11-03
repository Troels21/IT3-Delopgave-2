import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDB {

    public static LoginDB Mysql;

    static {
        Mysql = new LoginDB();
    }

    public static LoginDB getInstance() {
        return Mysql;
    }

    private ResultSet resultSet;
    private Statement statement;

    public ResultSet hentBrugerListe(String s) throws SQLException {
        SQL.getSqlOBJ().makeConnectionSQL();
        String query1 = "SELECT * FROM listedb.LoginOplysninger WHERE USERNAME = '"+s+"';";

        try {
            resultSet = statement.executeQuery(query1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        SQL.getSqlOBJ().removeConnectionSQL();
        return resultSet;
    }

}
