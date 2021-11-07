import com.google.gson.Gson;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;

@Path("aftaler")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML})
public class AftaleService {

    @GET
    public String getPatient() throws SQLException {
        return new Gson().toJson(SQL.getSqlOBJ().getAftalerListe());
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

    @Path("aftalerSQL")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String makepatientSQL(@QueryParam("cpr") String cpr, @QueryParam("name") String name, @QueryParam("timestart")
            String timestart, @QueryParam("timeend") String timeend, @QueryParam("note") String notat) throws SQLException, OurException {
        return AftaleController.getAftaleControllerOBJ().createAftale(cpr, name, timestart, timeend, notat);
    }

    @Path("aftalerSQL")
    @GET
    public String selectFromTime(@QueryParam("from") String from, @QueryParam("to") String to) throws SQLException {
        return new Gson().toJson(SQL.getSqlOBJ().getAftaleListeDateTime(from, to));
    }
}
