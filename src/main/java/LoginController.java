import java.sql.SQLException;

public class LoginController {

    private LoginController() {
    }

    static private final LoginController loginControllerOBJ = new LoginController();

    static public LoginController getLoginControllerOBJ() {
        return loginControllerOBJ;
    }

    public int loginVal(String user, String pass) throws SQLException, OurException {
        if (user.equals("") || pass.equals("")) {
            OurException ex = new OurException();
            ex.setMessage("Brugernavn eller Password mangler");
            throw ex;
            //throw new WebApplicationException("Brugernavn eller Password mangler", Response.Status.BAD_REQUEST); //400
        } else {
            String s = SQL.getSqlOBJ().hentBrugerListe(user);
            if (s.length() > 1) {
                String[] opdelt = s.split("A");
                if (opdelt[1].equals(pass)) {
                    return 1;
                }
            }
            return 0;
        }
    }
}

