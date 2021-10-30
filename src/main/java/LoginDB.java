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

    public ResultSet hentBrugerListe() {
        String query1 = "SELECT * FROM listedb.LoginOplysninger;";

        try {
            resultSet = statement.executeQuery(query1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }

}
