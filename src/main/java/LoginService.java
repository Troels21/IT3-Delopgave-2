import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

@Path("login")
public class LoginService {

    @POST
    public boolean loginKontrol(String s) throws SQLException {
        String[] opdelt1 = s.split("&");
        String navn = opdelt1[0].substring(5);
        String kode = opdelt1[1].substring(9);

        ResultSet data = LoginDB.getInstance().hentBrugerListe();
        while (data.next()) {
            if (Objects.equals(data.getString("username"), navn) && Objects.equals(data.getString("password"), kode)) {
                return true;
            }
        }
        return false;
    }
}
