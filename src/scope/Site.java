package scope;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;


@XmlRootElement(name = "site")
@XmlAccessorType(XmlAccessType.FIELD)
public class Site extends Scope {
    @XmlAttribute
    public String url;
    @XmlElement(name = "scenario")
    public ArrayList<Scenario> scenarios;

    public void parse() {
        Data.getData().put("url", getUrl());
        navigate(getUrl());
        System.out.println("Site Parsed");
        for (Scenario scenario : scenarios) {
            scenario.parse();
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ArrayList<Scenario> getScenarios() {
        if (scenarios == null) {
            scenarios = new ArrayList<Scenario>();
        }
        return scenarios;
    }

    public void setScenarios(ArrayList<Scenario> scenarios) {
        this.scenarios = scenarios;
    }
}
