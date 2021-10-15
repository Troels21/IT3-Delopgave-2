import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.*;

@Path("liste")
@Produces({MediaType.APPLICATION_XML})
public class ListeService {

        XmlMapper mapper = new XmlMapper();
        ListeRepo repo = new ListeRepo();

        @GET
        public FileReader getPatient() throws IOException {
            //return repo.getpatientList();
            return new FileReader("patientlist");
        }

        @POST
        @Produces({MediaType.APPLICATION_XML})½
        @Path("postliste")
        public String makePatient(String xml) throws IOException {
            Patient patient = mapper.readValue(xml,Patient.class);
            repo.create(patient);
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            String xmlString = mapper.writeValueAsString(repo.getpatientList());
            System.out.println(xmlString);
            FileWriter fw = new FileWriter("patientlist",true);
            fw.write(xmlString);
            return xmlString;
        }
    }
