import com.google.gson.Gson;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;

@Path("liste")
@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_FORM_URLENCODED})
public class ListeService {
    @GET
    public String getPatient() throws SQLException {
        //return ListeRepo.getInstance().getpatientList();
        //return new FileReader("patientlist");
        String json = new Gson().toJson(ListeDB.getInstance().getpatientList());
        return json;
    }
    /*
    @POST
    public String makePatient(Patient patient) throws SQLException {
        ListeDB.getInstance().insertPatientSQL(patient);
            //ListeRepo.getInstance().create(patient);
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            String xmlString = mapper.writeValueAsString(ListeRepo.getInstance().getpatientList());
            System.out.println(xmlString);
            FileWriter fw = new FileWriter("patientlist",true);
            fw.write(xmlString);
        return "added patient: " + patient.toString();
    }*/

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
