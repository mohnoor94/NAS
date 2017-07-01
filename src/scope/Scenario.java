package scope;

import framework.Reporter;
import scope.unit.Unit;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

/**
 *
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
        Reporter reporter = Reporter.getInstance();
        reporter.addHeader("scenario", getName());
        for (Unit unit : units) {
            unit.parse();
        }
        reporter.addFooter("scenario", getName());
    }

    public Scenario(String name) {
        this.name = name;
    }

    public Scenario() {
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
