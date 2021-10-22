import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.*;
import java.sql.SQLException;
import java.util.List;

@Path("liste")
@Produces({MediaType.APPLICATION_XML})
@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_FORM_URLENCODED})
public class ListeService {
    @GET
    public List<Patient> getPatient() throws IOException, SQLException {
        //return ListeRepo.getInstance().getpatientList();
        //return new FileReader("patientlist");
        return ListeDB.getInstance().getpatientList();
    }

    @POST
    public String makePatient(Patient patient) throws IOException, SQLException {
        ListeDB.getInstance().insertPatientSQL(patient);
            /*ListeRepo.getInstance().create(patient);
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            String xmlString = mapper.writeValueAsString(ListeRepo.getInstance().getpatientList());
            System.out.println(xmlString);
            FileWriter fw = new FileWriter("patientlist",true);
            fw.write(xmlString);*/
        return "added patient: " + patient.toString();
    }

    @POST
    @Path("liste2")
    public String makepatientSQL(String s) throws SQLException {

        String[] opdelt1 = s.split("&");

        Patient patient = new Patient();
        patient.setCpr(opdelt1[0].substring(4));
        patient.setName(cleanupString(opdelt1[1].substring(5)));
        patient.setTimestart(cleanupTime(opdelt1[2].substring(10)));
        patient.setTimeend(cleanupTime(opdelt1[3].substring(8)));
        patient.setNote(cleanupString(opdelt1[4].substring(5)));

        ListeDB.getInstance().insertPatientSQL(patient);
        return "added patient: " + patient.toString();
    }

    //Andreas Kig væk det her er ikke pænt, og det er du skal bare minimere metoden (den virker end of story).
    public String cleanupTime(String s) {
        int plus = s.indexOf("+");
        int unicode = s.indexOf("%");
        int weirdA = s.indexOf("A");
        String Cleanup = "";
        Cleanup = s.substring(0, plus);
        Cleanup = Cleanup + " " + s.substring(plus + 1, unicode);
        Cleanup = Cleanup + ":" + s.substring(weirdA + 1);
        return Cleanup;
    }

    public String cleanupString(String s) {
        if (s.indexOf("+") > 0) {
            String[] cleanArray = s.split("\\+");
            String CleanNote = cleanArray[0];
            for (int i = 1; i < cleanArray.length; i++) {
                CleanNote = CleanNote + " " + cleanArray[i];
            }

            return CleanNote;
        } else return s;
    }
}
