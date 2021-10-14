import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Patient implements Serializable {

    private String cpr;
    private String name;

    @Override
    public String toString() {
        return "Patient{" +
                "cpr='" + cpr + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getCpr() {
        return cpr;
    }

    public void setCpr(String cpr) {
        this.cpr = cpr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
