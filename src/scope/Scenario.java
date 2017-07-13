package scope;

import data.Data;
import framework.Reporter;
import scope.dependency.Dependency;
import scope.unit.Unit;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

/**
 * @author AbuKhleif
 */
@XmlRootElement(name = "scenario")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Dependency.class})
@XmlType(propOrder = {"name", "dependencies", "units"})
public class Scenario extends Scope {
    @XmlAttribute
    private String name;
    @XmlElementRef
    private ArrayList<Unit> units;
    @XmlElementRef
    private ArrayList<Dependency> dependencies;


    public void parse() {
        Reporter reporter = Reporter.getInstance();
        String dep = getDependenciesAsString();
        if (dep != null && !dep.equals("")) {
            reporter.addHeader("Dependency", "Scenario '" + getName() + "' skipped.<br>" +
                    "Reason: Scenario is depending on previous failed scenario(s): { " + dep + "}");
            // Set the status of scenario
            Data.getScenariosStatus().put(getName(), false);
        } else {
            reporter.addHeader("scenario", getName());
            for (Unit unit : units) {
                unit.parse();
            }
            reporter.addFooter("scenario", getName());
            // Set the status of scenario
            Data.getScenariosStatus().put(getName(), (Reporter.getFailCounter() == 0));
        }
        // Reset failCounter
        Reporter.resetFailCounter();
    }

    public Scenario(String name) {
        this.name = name;
    }

    public Scenario() {
    }

    public String getName() {
        if (name == null) {
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

    public ArrayList<Dependency> getDependencies() {
        if (dependencies == null) {
            dependencies = new ArrayList<>();
        }
        return dependencies;
    }

    public void addDependency(Dependency dependency) {
        getDependencies().add(dependency);
    }

    private String getDependenciesAsString() {
        if (getDependencies().isEmpty()) {
            return null;
        } else {
            StringBuilder sb = new StringBuilder();
            boolean hasContent = false;
            for (Dependency dependency : dependencies) {
                if (dependency.getScenario() != null && !Data.getScenariosStatus().get(dependency.getScenario())) {
                    sb.append(dependency.getScenario());
                    sb.append(", ");
                    hasContent = true;
                }
            }
            if (hasContent) {
                int commaIndex = sb.lastIndexOf(",");
                sb.delete(commaIndex, commaIndex + 1);
            }
            return sb.toString();
        }
    }
}
