import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;

@Path("login")
@Produces({MediaType.TEXT_PLAIN})
public class LoginService {

    @GET
    public int loginKontrol(@QueryParam("username") String user, @QueryParam("password") String pass) throws SQLException {
        String s = LoginDB.getInstance().hentBrugerListe(user);
        if(s.length()>1){
            String[] opdelt = s.split("A");
            if(opdelt[1].equals(pass)){
                return 1;
            }
        }
        return 0;
    }
}
