import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.io.*;

@Path("patients")
public class PatientService {
    XmlMapper mapper = new XmlMapper();
    @GET
    public String getPatient() throws IOException {
        Patient user= new Patient();
        user.setCpr("123");
        user.setName("bo");
        String xmlString = mapper.writeValueAsString(user);
        System.out.println(xmlString);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.writeValue(new File("Patient.xml"),user);
        /*
        Patient patientFromXML = mapper.readValue(new File("Patients.xml"), Patient.class);
        return ("Read from XML: "+patientFromXML);*/
        return null;
    }


}
