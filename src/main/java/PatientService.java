import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.io.*;


@Path("patients")
public class PatientService {
    String s ="patient43";
    XmlMapper mapper = new XmlMapper();
    @GET
    public Patient getPatient() throws IOException {
        return mapper.readValue(new FileInputStream(s),Patient.class);
    }

    @POST
    public String makePatient(String xml) throws IOException {
        Patient patient = mapper.readValue(xml,Patient.class);

        String xmlString = mapper.writeValueAsString(patient);
        System.out.println(xmlString);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.writeValue(new FileWriter(s),patient);
        return ("wrote "+patient);
    }
}
