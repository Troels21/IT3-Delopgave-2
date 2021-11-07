import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;

@Path("login")
@Produces({MediaType.TEXT_PLAIN})
public class LoginService {

    @GET
    public int loginKontrol(@QueryParam("username") String user, @QueryParam("password") String pass) throws SQLException, OurException {
        return LoginController.getLoginControllerOBJ().loginVal(user, pass);
    }
}
