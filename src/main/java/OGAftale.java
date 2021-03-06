import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@jakarta.xml.bind.annotation.XmlRootElement
public class OGAftale implements Serializable {

    private String cpr;
    private String name;
    private String timestart;
    private String timeend;
    private String note;

    @Override
    public String toString() {
        return "Aftale{" +
                "cpr='" + cpr + '\'' +
                ", name='" + name + '\'' +
                ", timestart='" + timestart + '\'' +
                ", timeend='" + timeend + '\'' +
                ", note='" + note + '\'' +
                '}';
    }

    public String getTimestart() {
        return timestart;
    }

    public void setTimestart(String timestart) {
        this.timestart = timestart;
    }

    public String getTimeend() {
        return timeend;
    }

    public void setTimeend(String timeend) {
        this.timeend = timeend;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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
