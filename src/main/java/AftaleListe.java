import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlSeeAlso(Aftale.class)
public class AftaleListe {

    List<Aftale> aftaleliste = new ArrayList<>();

    public List<Aftale> getAftaler() {
        return aftaleliste;
    }

    public void addAftaler(Aftale aftale) {
        aftaleliste.add(aftale);
    }
}
