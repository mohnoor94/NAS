package scope.dependency;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author AbuKhleif
 */
@XmlRootElement(name = "dependency")
@XmlAccessorType(XmlAccessType.FIELD)
public class Dependency {
    @XmlAttribute
    private String scenario;

    public Dependency() {
    }

    public Dependency(String scenario) {
        this.scenario = scenario;
    }

    public String getScenario() {
        return scenario;
    }

    public void setScenario(String scenario) {
        this.scenario = scenario;
    }
}
