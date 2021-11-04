import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("listes")
@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_FORM_URLENCODED})
public class ImportService {

    @GET
    public String importerxml(@QueryParam("noget") String s){
        /*find på noget smart her*/
        System.out.println("tjek");
        return s;
    }

}
