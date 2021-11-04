import com.google.gson.Gson;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

@Path("liste")
@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_FORM_URLENCODED})
public class ListeService {
    @GET
    public List<Patient> getPatient() throws SQLException {
        return ListeDB.getInstance().getpatientList();
    }

    @Path("listeSQL")
    @POST
    public String makepatientSQL(@FormParam("cpr") String cpr, @FormParam("name") String name, @FormParam("timestart") String timestart, @FormParam("timeend") String timeend, @FormParam("note") String notat) throws SQLException {
        Patient patient = new Patient();
        patient.setCpr(cpr);
        patient.setName(name);
        patient.setTimestart(timestart);
        patient.setTimeend(timeend);
        patient.setNote(notat);

        ListeDB.getInstance().insertPatientSQL(patient);
        return "added patient: " + patient.toString();
    }

    @Path("listeSQL")
    @GET
    public String selectFromTime(@QueryParam("from") String from, @QueryParam("to") String to) throws SQLException {

        String json = new Gson().toJson(ListeDB.getInstance().getpatientListeDateTime(from, to));

        return json;
    }
}
