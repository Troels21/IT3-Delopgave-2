import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.sql.ResultSet;
import java.sql.SQLException;

@Path("login")
public class LoginService {

    @POST
    public int loginKontrol(@QueryParam("username") String user, @QueryParam("password") String pass) throws SQLException {

        ResultSet data = LoginDB.getInstance().hentBrugerListe(user);
        if(data.getString(0).length()>0){
            if(data.getString(1).equals(pass)){
                return 1;
            }
        }
        return 0;
    }
}
