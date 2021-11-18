import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Aftale {



    private String CPR;
    private String ID;
    private String KlinikID;
    private String TimeStart;
    private String TimeEnd;
    private String Notat;

    @Override
    public String toString() {
        return "Aftale{" +
                "CPR='" + CPR + '\'' +
                ", ID='" + ID + '\'' +
                ", KlinikID='" + KlinikID + '\'' +
                ", TimeStart='" + TimeStart + '\'' +
                ", TimeEnd='" + TimeEnd + '\'' +
                ", Notat='" + Notat + '\'' +
                '}';
    }

    public String getCPR() {
        return CPR;
    }

    public void setCPR(String CPR) {
        this.CPR = CPR;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getKlinikID() {
        return KlinikID;
    }

    public void setKlinikID(String klinikID) {
        KlinikID = klinikID;
    }

    public String getTimeStart() {
        return TimeStart;
    }

    public void setTimeStart(String timeStart) {
        TimeStart = timeStart;
    }

    public String getTimeEnd() {
        return TimeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        TimeEnd = timeEnd;
    }

    public String getNotat() {
        return Notat;
    }

    public void setNotat(String notat) {
        Notat = notat;
    }
}
