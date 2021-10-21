import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.*;
import java.sql.SQLException;
import java.util.List;

@Path("liste")
@Produces({MediaType.APPLICATION_XML})
@Consumes(MediaType.APPLICATION_XML)
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
            return "added patient: "+patient.toString();
        }
    }
