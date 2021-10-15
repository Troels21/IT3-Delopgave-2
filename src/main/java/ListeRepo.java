import java.util.ArrayList;
import java.util.List;

public class ListeRepo {
     public static ListeRepo repo = new ListeRepo();
     List<Patient> patientList;

     public static ListeRepo getInstance() {
         return repo;
     }
    private ListeRepo(){
        patientList = new ArrayList<>();

        Patient p1 = new Patient();
        p1.setCpr("1");
        p1.setName("test1");

        Patient p2 = new Patient();
        p2.setCpr("2");
        p2.setName("test2");

        patientList.add(p1);
        patientList.add(p2);
    }

    public List<Patient> getpatientList(){
        return patientList;
    }

    public void create(Patient p){
        patientList.add(p);
    }
}
