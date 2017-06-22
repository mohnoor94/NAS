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
        // TODO report scenario header
        for (Unit unit : units) {
            unit.parse();
        }
    }

    public String getName() {
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
