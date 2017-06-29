package scope;

import scope.unit.Unit;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

/**
 * @author AbuKhleif
 */
@XmlRootElement(name = "scenario")
@XmlAccessorType(XmlAccessType.FIELD)
public class Scenario extends Scope {
    @XmlAttribute
    private String name;
    @XmlElementRef
    private ArrayList<Unit> units;

    public void parse() {
        addHeader("scenario", getName());
        for (Unit unit : units) {
            unit.parse();
        }
        addFooter("scenario", getName());
    }

    public String getName() {
        if (name == null){
            name = "UNKNOWN";
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Unit> getUnits() {
        if (units == null) {
            units = new ArrayList<Unit>();
        }
        return units;
    }
}
